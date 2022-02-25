package test.map.mvvmgogo.mvvm_RecyclerView_Package

import android.app.Application
import androidx.lifecycle.LiveData

class TodoRepository(application: Application) {
    private val todoDao: TodoDao
    private val todoList: LiveData<List<Todo>>

    init {
        var db = AppDatabase.getInstance(application)
        todoDao = db!!.todoDao()
        todoList = db.todoDao().getAll()
    }

    fun insert(todo: Todo){
        todoDao.insert(todo)
    }

    fun delete(todo: Todo){
        todoDao.delete(todo)
    }

    fun getAll(): LiveData<List<Todo>>{
        return todoDao.getAll()
    }
}