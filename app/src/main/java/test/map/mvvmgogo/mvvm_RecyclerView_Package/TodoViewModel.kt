package test.map.mvvmgogo.mvvm_RecyclerView_Package

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class TodoViewModel(application: Application): AndroidViewModel(application) {

    private val repository = TodoRepository(application)
    private val items = repository.getAll()

    fun insert(todo:Todo){
        repository.insert(todo)
    }

    fun delete(todo: Todo){
        repository.insert(todo)
    }

    fun getAll() : LiveData<List<Todo>>{
        return items
    }
}