package test.map.mvvmgogo.multiRecyclerView_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import test.map.mvvmgogo.R
import test.map.mvvmgogo.databinding.ActivityMultiViewBinding

class MultiViewActivity : AppCompatActivity() {

    private var multiViewBinding: ActivityMultiViewBinding? = null
    private val binding get() = multiViewBinding!!

    lateinit var multiAdapter: Multi_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        multiViewBinding = ActivityMultiViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerView()
    }

    private fun setRecyclerView() {

        multiAdapter = Multi_Adapter()
        val multidata = mutableListOf(
            MultiData(
                R.drawable.ic_launcher_background,
                "승현",
                27,
                type = 1
            ),
            MultiData(
                R.drawable.ic_launcher_background,
                "승현",
                27,
                type = 2
            ),
            MultiData(
                R.drawable.ic_launcher_background,
                "승현",
                27,
                type = 1
            )
        )

        binding.MultirecyclerView.apply {
            adapter = multiAdapter
            layoutManager= LinearLayoutManager(context)
            multiAdapter.submitList(multidata)
        }


    }
}