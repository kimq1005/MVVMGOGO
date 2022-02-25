package test.map.mvvmgogo.dataBinding_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import test.map.mvvmgogo.databinding.ActivityDataBindingMainBinding

class DataBinding_MainActivity : AppCompatActivity() {

    private var dataViewModelMainBinding : ActivityDataBindingMainBinding?=null
    private val binding get() = dataViewModelMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataViewModelMainBinding = ActivityDataBindingMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //데이터 바인딩을 사용하는 클래스 이름 은 대문자 로 시작하고 패키지 이름은 소문자로 해야댐
        binding.profile = Profiles("김","승현")


    }
}