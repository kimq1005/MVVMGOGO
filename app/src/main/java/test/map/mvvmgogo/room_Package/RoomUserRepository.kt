package test.map.mvvmgogo.room_Package

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.RoomDatabase

class RoomUserRepository(application: Application) {

    private var roomUserDao : RoomUserDao
    private var userList :LiveData<List<RoomUser>>

    init {
        var db : RoomUser_DataBase = RoomUser_DataBase.getInstance(application)!!
        roomUserDao = db.roomUserDao()
        userList = db.roomUserDao().getAll()
    }

    fun insert(roomuser:RoomUser){
        roomUserDao.insert(roomuser)
    }


    fun update(roomuser:RoomUser){
        roomUserDao.update(roomuser)
    }

    fun delete(roomuser: RoomUser){
        roomUserDao.delete(roomuser)
    }

    fun getAll(): LiveData<List<RoomUser>>{
        return roomUserDao.getAll()
    }

    fun deleteAll(){
        roomUserDao.deleteAll()
    }
}