package test.map.mvvmgogo.recycler_package

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.map.mvvmgogo.databinding.MainitemBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    lateinit var userProfilesList : MutableList<UserProfiles>

    inner class MyViewHolder(val binding: MainitemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(userProfiles: UserProfiles) {
            binding.userprofiles = userProfiles

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = MainitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userProfilesList[position])
    }

    override fun getItemCount(): Int {
        return userProfilesList.size
    }

    fun submitList(list : ArrayList<UserProfiles>){
        userProfilesList = list
        notifyDataSetChanged()
    }
}