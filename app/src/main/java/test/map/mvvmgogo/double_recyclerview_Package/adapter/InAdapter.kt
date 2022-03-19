package test.map.mvvmgogo.double_recyclerview_Package.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.map.mvvmgogo.databinding.RecyclerviewInItemBinding
import test.map.mvvmgogo.double_recyclerview_Package.RecyclerInViewModel

class InAdapter : RecyclerView.Adapter<InAdapter.InHolder>() {

    lateinit var recyclerInViewModel: MutableList<RecyclerInViewModel>

    inner class InHolder(var binding: RecyclerviewInItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecyclerInViewModel) {
            binding.model = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InHolder {
        val view = RecyclerviewInItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return InHolder(view)
    }

    override fun onBindViewHolder(holder: InHolder, position: Int) {
        holder.bind(recyclerInViewModel[position])
    }

    override fun getItemCount(): Int {
       return recyclerInViewModel.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list : MutableList<RecyclerInViewModel>){
        recyclerInViewModel = list
        notifyDataSetChanged()
    }
}