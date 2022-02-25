package test.map.mvvmgogo.mvvm_RecyclerView_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import test.map.mvvmgogo.databinding.ActivityMvvmRecyclerViewMainBinding

class Mvvm_RecyclerView_MainActivity : AppCompatActivity() {

    private var mvvmRecyclerViewMainBinding:ActivityMvvmRecyclerViewMainBinding?=null
    private val binding get() = mvvmRecyclerViewMainBinding!!

    private lateinit var todoadapter : TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvvmRecyclerViewMainBinding = ActivityMvvmRecyclerViewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}