package test.map.mvvmgogo.double_recyclerview_Package

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import test.map.mvvmgogo.databinding.FragmentMainBinding
import test.map.mvvmgogo.double_recyclerview_Package.adapter.InAdapter
import test.map.mvvmgogo.double_recyclerview_Package.adapter.OutAdapter

class MainFragment :Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var outAdapter: OutAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)

        setRecyclerView()
        return binding.root
    }

    private fun setRecyclerView() {
        outAdapter = OutAdapter()

        var itemList = mutableListOf(
            RecyclerOutViewModel("김승현" , mutableListOf(
                RecyclerInViewModel("뭘봐요" , "강아지"),
                RecyclerInViewModel("뭘봐요" , "고양이"),
            ))
        )


        binding.outRecyclerview.apply {
            adapter = outAdapter
            layoutManager = LinearLayoutManager(context)
            outAdapter.submitList(itemList)
        }
    }
}