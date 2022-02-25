package test.map.mvvmgogo.mvvm_RecyclerView_Package

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.map.mvvmgogo.databinding.TodoitemBinding

class TodoAdapter(listener:OnitemClick):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    private val mCallback = listener
    lateinit var items :List<Todo>

    inner class TodoViewHolder(val binding :TodoitemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:Todo){
            binding.tvTodo.text = item.content
            binding.ivIcon.setOnClickListener {
                mCallback.deleteTodo(item)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = TodoitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list:ArrayList<Todo>){
        items = list
        notifyDataSetChanged()

    }
}