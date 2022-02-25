package test.map.mvvmgogo.LiveData_ViewModel_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import test.map.mvvmgogo.databinding.ActivityLiveDataViewModelMainBinding

class LiveData_ViewModel_MainActivity : AppCompatActivity() , View.OnClickListener {

    private var liveDataViewModelMainBinding : ActivityLiveDataViewModelMainBinding?=null
    private val binding get() = liveDataViewModelMainBinding!!

    lateinit var lD_VM_ViewModel :LD_VM_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        liveDataViewModelMainBinding = ActivityLiveDataViewModelMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.plusbtn.setOnClickListener(this)
        binding.minusbtn.setOnClickListener(this)

        lD_VM_ViewModel=ViewModelProvider(this).get(LD_VM_ViewModel::class.java)

        lD_VM_ViewModel.currentValue.observe(this, Observer {
            binding.resulttetview.text = it.toString()
        })

    }

    override fun onClick(view: View?) {
       when(view){
           binding.plusbtn->{
               lD_VM_ViewModel.UpdataValue(actionType.Plus , binding.edittextview.text.toString().toInt())
           }

           binding.minusbtn->{
               lD_VM_ViewModel.UpdataValue(actionType.MINUS , binding.edittextview.text.toString().toInt())
           }
       }
    }
}