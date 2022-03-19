package test.map.mvvmgogo.multiRecyclerView_Package

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import test.map.mvvmgogo.databinding.MultiOneItemBinding
import test.map.mvvmgogo.databinding.MultiThreeItemBinding
import test.map.mvvmgogo.databinding.MultiTwoItemBinding

class Multi_Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var multiData: MutableList<MultiData>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            multi_type1 -> {
                val view =
                    MultiOneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiHolder_one(view)
            }

            multi_type2 -> {
                val view =
                    MultiTwoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiHolder_two(view)
            }

            else -> {
                val view = MultiThreeItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                MultiHolder_three(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (multiData[position].type) {
            multi_type1 -> {
                (holder as MultiHolder_one).bind(multiData[position])
                holder.setIsRecyclable(false)
            }

            multi_type2 -> {
                (holder as MultiHolder_two).bind(multiData[position])
                holder.setIsRecyclable(false)
            }

            multi_type3 -> {
                (holder as MultiHolder_three).bind(multiData[position])
                holder.setIsRecyclable(false)

            }

        }
    }

    override fun getItemCount(): Int {
        return multiData.size
    }

    override fun getItemViewType(position: Int): Int {
        return multiData[position].type
    }



    inner class MultiHolder_one(var binding: MultiOneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MultiData) {
            binding.tvRvName.text = item.name
            binding.tvRvAge.text = item.age.toString()
            Glide.with(itemView).load(item.image).into(binding.imgRvPhoto)
        }

    }


    inner class MultiHolder_two(var binding: MultiTwoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MultiData) {
            binding.tvRvName.text = item.name
            binding.tvRvAge.text = item.age.toString()
            Glide.with(itemView).load(item.image).into(binding.imgRvPhoto)
        }

    }

    inner class MultiHolder_three(var binding: MultiThreeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MultiData) {
            binding.tvRvName.text = item.name
            Glide.with(itemView).load(item.image).into(binding.imgRvPhoto)
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list:MutableList<MultiData>){
        multiData = list
        notifyDataSetChanged()
    }


    companion object {
        private const val multi_type1 = 1
        private const val multi_type2 = 2
        private const val multi_type3 = 3

    }


}