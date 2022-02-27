package test.map.mvvmgogo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import test.map.mvvmgogo.dataBinding_Package.DataBinding_MainActivity
import test.map.mvvmgogo.LiveData_ViewModel_Package.LiveData_ViewModel_MainActivity
import test.map.mvvmgogo.retrofit_MvvmPackage.Retrofit_Mvvm_MainActivity
import test.map.mvvmgogo.databinding.ActivityMainBinding
import test.map.mvvmgogo.recycler_package.recy_main_activity
import test.map.mvvmgogo.room_Package.RoomMvvm_MainActivity

class MainActivity : AppCompatActivity() {

    private var mainBinding : ActivityMainBinding ? =null
    private val binding get() = mainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LiveDataViewModelActivity.setOnClickListener {
            val intent = Intent(this, LiveData_ViewModel_MainActivity::class.java)
            startActivity(intent)
        }

        binding.DataBindingActivity.setOnClickListener {
            val intent = Intent(this, DataBinding_MainActivity::class.java)
            startActivity(intent)
        }

        binding.recymainview.setOnClickListener {
            val intent = Intent(this, recy_main_activity::class.java)
            startActivity(intent)
        }

        binding.roomactivity.setOnClickListener{
            val intent = Intent(this, Retrofit_Mvvm_MainActivity::class.java)
            startActivity(intent)
        }

        binding.roomMvvmMainActivity.setOnClickListener {
            val intent = Intent(this, RoomMvvm_MainActivity::class.java)
            startActivity(intent)
        }


    }
}