package test.map.mvvmgogo.retrofit_MvvmPackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import test.map.mvvmgogo.retrofit_MvvmPackage.roomDB.TestRoomViewModel

class Retrofit_Mvvm_MainActivity : AppCompatActivity() {

    private var retrofitMvvmMainBinding: ActivityRetrofitMvvmMainBinding? = null
    private val binding get() = retrofitMvvmMainBinding!!


    private var retrofitInterface: Retrofit_InterFace =
        Retrofit_Client.getClient("http://openapi.tago.go.kr/openapi/service/")
            .create(Retrofit_InterFace::class.java)


    private lateinit var retrofitMvvmAdapter: Retrofit_Mvvm_Adapter
    private lateinit var retrofitMainviewmodel: Retrofit_MainViewModel

    private lateinit var roomViewModel: TestRoomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retrofitMvvmMainBinding = ActivityRetrofitMvvmMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//

        retrofitMainviewmodel = ViewModelProvider(this).get(Retrofit_MainViewModel::class.java)
        roomViewModel = ViewModelProvider(this,  TestRoomViewModel.Factory(application)).get(TestRoomViewModel::class.java)
        setRetrofitCall("31010", "우남")

        binding.titleTextview.text = "우남 아파트"

        binding.saveBtn.setOnClickListener {
            getAll()
        }






    }

    private fun saveData() {
        binding.saveBtn.setOnClickListener {
            val stationname = TestEntity(null,binding.titleTextview.text.toString())
            roomViewModel.addStation(binding.titleTextview.text.toString())
            Toast.makeText(this,"저장 완료",Toast.LENGTH_SHORT).show()
        }
    }


    private fun getAll(){

        roomViewModel.getAllstation().observe(this, Observer {
            Log.d(TAG, "getall 테스트: $it")
        })

    }


    private fun setRetrofitCall(citycode: String, stationName: String?) {
        val stationcall = retrofitInterface.StationNameGet(citycode, stationName, null)

        stationcall.enqueue(object : retrofit2.Callback<StationBus> {
            override fun onResponse(call: Call<StationBus>, response: Response<StationBus>) {
                val body = response.body()
                body?.let {
                    val hello = body.body.items.item
                    retrofitMainviewmodel.setStationBusItem(hello)



                    //이게 실질적으로 데이터가 저장되어있는 viewModel에서 데이터를 불러온거임
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


}