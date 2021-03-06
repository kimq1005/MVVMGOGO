package test.map.mvvmgogo.retrofit_MvvmPackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Response
import test.map.mvvmgogo.retrofit_MvvmPackage.retrofit.Retrofit_Client
import test.map.mvvmgogo.retrofit_MvvmPackage.retrofit.Retrofit_InterFace
import test.map.mvvmgogo.Utils.Companion.TAG
import test.map.mvvmgogo.databinding.ActivityRetrofitMvvmMainBinding
import test.map.mvvmgogo.retrofit_MvvmPackage.roomDB.TestEntity
import test.map.mvvmgogo.retrofit_MvvmPackage.roomDB.TestRoomAdapter
import test.map.mvvmgogo.retrofit_MvvmPackage.roomDB.TestRoomViewModel

class Retrofit_Mvvm_MainActivity : AppCompatActivity(), OnDeleteInterFace {

    private var retrofitMvvmMainBinding: ActivityRetrofitMvvmMainBinding? = null
    private val binding get() = retrofitMvvmMainBinding!!


    private var retrofitInterface: Retrofit_InterFace =
        Retrofit_Client.getClient("http://openapi.tago.go.kr/openapi/service/")
            .create(Retrofit_InterFace::class.java)


    private lateinit var retrofitMvvmAdapter: Retrofit_Mvvm_Adapter
    private lateinit var roomAdapter: TestRoomAdapter



    private lateinit var retrofitMainviewmodel: Retrofit_MainViewModel
    private lateinit var roomViewModel: TestRoomViewModel

    lateinit var testEntity : List<TestEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retrofitMvvmMainBinding = ActivityRetrofitMvvmMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//

        retrofitMainviewmodel = ViewModelProvider(this).get(Retrofit_MainViewModel::class.java)
        roomViewModel = ViewModelProvider(this,  TestRoomViewModel.Factory(application)).get(TestRoomViewModel::class.java)
        setRetrofitCall("31010", "??????")

        saveData()
        getAll()

        binding.titleTextview.text = "?????? ?????????"

//        setRoomRecyclerView()
        testgetAll()



    }

    private fun testgetAll(){
        roomViewModel.getAllstation().observe(this, Observer {
            Log.d(TAG, "????????????????????????: $it")
        })
        Log.d(TAG, "????????????????????????: ${roomViewModel.getAllstation()}")
    }

    private fun setRoomRecyclerView() {

        roomAdapter = TestRoomAdapter(this)

        roomViewModel.testEntity.observe(this, Observer {
            roomAdapter.submitlist(it)
        })

        binding.roomRecyclerView.apply {
            adapter = roomAdapter
            layoutManager = LinearLayoutManager(context)
        }


    }

    private fun saveData() {
        binding.saveBtn.setOnClickListener {
            roomViewModel.addStation(binding.titleTextview.text.toString())
        }
    }

    private fun delete(testEntity: TestEntity){
        roomViewModel.deleteStation(testEntity)
    }


    private fun getAll(){
        roomAdapter = TestRoomAdapter(this)
        roomViewModel.getAllstation().observe(this, Observer {
            roomAdapter.submitlist(it)
        })

        binding.roomRecyclerView.apply {
            adapter = roomAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }


    private fun setRetrofitCall(citycode: String, stationName: String?) {
        val stationcall = retrofitInterface.StationNameGet(citycode, stationName, null)

        stationcall.enqueue(object : retrofit2.Callback<StationBus> {
            override fun onResponse(call: Call<StationBus>, response: Response<StationBus>) {
                val body = response.body()
                body?.let {
                    val hello = body.body.items.item
                    retrofitMainviewmodel.setStationBusItem(hello)



                    //?????? ??????????????? ???????????? ?????????????????? viewModel?????? ???????????? ???????????????
                    retrofitMainviewmodel.stationItem.observe(
                        this@Retrofit_Mvvm_MainActivity,
                        Observer { it ->
                            setRecyclerView(it)
                        })
                }
            }

            override fun onFailure(call: Call<StationBus>, t: Throwable) {
                Log.d(TAG, "onFailure: $t")
            }

        })
    }

    private fun setRecyclerView(stationItem: List<StationItem>){
        retrofitMvvmAdapter = Retrofit_Mvvm_Adapter()

        binding.myrecyclreView.apply {
            adapter = retrofitMvvmAdapter
            layoutManager=LinearLayoutManager(context)
            retrofitMvvmAdapter.submitList(stationItem)
        }
    }



    private fun RecyclerView(stationItem: List<StationItem>){
        retrofitMvvmAdapter = Retrofit_Mvvm_Adapter()

        binding.myrecyclreView.apply {
            adapter = retrofitMvvmAdapter
            layoutManager=LinearLayoutManager(context)
            retrofitMvvmAdapter.submitList(stationItem)
        }
    }

    override fun onDeleteStationList(testEntity: TestEntity) {
        delete(testEntity)
    }


}