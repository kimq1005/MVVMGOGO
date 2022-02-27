package test.map.mvvmgogo.recycler_package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import test.map.mvvmgogo.databinding.ActivityRecyMainBinding

class recy_main_activity : AppCompatActivity() {

    private var recyMainBinding : ActivityRecyMainBinding?=null
    private val binding get() = recyMainBinding!!

    lateinit var myAdapter: MyAdapter
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyMainBinding = ActivityRecyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = mainViewModel

        recyclerViewset()

    }

    private fun recyclerViewset() {


        myAdapter = MyAdapter()

        mainViewModel.userProfilesList.observe(this, Observer {
            myAdapter.submitList(it)
        })


        binding.myrecyclreView.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(context)
        }



    }
}