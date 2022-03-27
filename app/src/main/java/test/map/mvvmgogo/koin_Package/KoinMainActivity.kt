package test.map.mvvmgogo.koin_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import test.map.mvvmgogo.databinding.ActivityKoinMainBinding

class KoinMainActivity : AppCompatActivity() {

    private var koinMainBinding : ActivityKoinMainBinding?=null
    private val binding get() = koinMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        koinMainBinding = ActivityKoinMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@KoinMainActivity)
            modules(myModule)
        }

    }



}


