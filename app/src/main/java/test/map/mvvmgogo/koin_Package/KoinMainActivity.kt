package test.map.mvvmgogo.koin_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.get
import test.map.mvvmgogo.databinding.ActivityKoinMainBinding

class KoinMainActivity : AppCompatActivity() {
    private var koinMainBinding : ActivityKoinMainBinding?=null
    private val binding get() = koinMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        koinMainBinding = ActivityKoinMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val student = get<Student>()
        student.beSamrt()

    }
}