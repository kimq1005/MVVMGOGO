package test.map.mvvmgogo.room_Package

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Room_UserViewModel(application: Application): AndroidViewModel(application) {
    private val repository = RoomUserRepository(application)

    class Factory(val application: Application):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return Room_UserViewModel(application) as T
        }
    }

    fun addUser(name:String, age :String){
        val user = RoomUser(name, age)

        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(user)
        }
    }

    fun getAll():LiveData<List<RoomUser>>{
        return repository.getAll()
    }

    fun deleteAll(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteAll()
        }
    }
}