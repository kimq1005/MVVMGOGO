package test.map.mvvmgogo.double_recyclerview_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import test.map.mvvmgogo.databinding.ActivityDoubleRecyclerViewMainBinding

class Double_RecyclerViewMainActivity : AppCompatActivity() {

    private var doublebinding: ActivityDoubleRecyclerViewMainBinding ? = null
    private val binding get() = doublebinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        doublebinding = ActivityDoubleRecyclerViewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id , MainFragment())
            .commit()

    }
}