package test.map.mvvmgogo.double_recyclerview_Package.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import test.map.mvvmgogo.databinding.RecyclerviewOutItemBinding
import test.map.mvvmgogo.double_recyclerview_Package.RecyclerOutViewModel

class OutAdapter : RecyclerView.Adapter<OutAdapter.Holder>() {

    lateinit var inAdapter: InAdapter

    lateinit var outViewModel: MutableList<RecyclerOutViewModel>

    inner class Holder(var binding: RecyclerviewOutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RecyclerOutViewModel) {
            inAdapter = InAdapter()
            binding.model = item

            binding.innerRecyclerview.adapter

            binding.innerRecyclerview.apply {

                adapter = inAdapter
                layoutManager = LinearLayoutManager(context)
                inAdapter.submitList(item.innerList)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            RecyclerviewOutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.bind(outViewModel[position])
    }

    override fun getItemCount(): Int {
        return outViewModel.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list : MutableList<RecyclerOutViewModel>){
        outViewModel = list
        notifyDataSetChanged()
    }
}