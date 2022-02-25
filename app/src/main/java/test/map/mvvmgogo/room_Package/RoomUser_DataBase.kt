package test.map.mvvmgogo.room_Package

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [RoomUser::class], version = 2)
abstract class RoomUser_DataBase :RoomDatabase() {
    abstract fun roomUserDao() : RoomUserDao

    companion object{
        private var instance: RoomUser_DataBase?=null

        @Synchronized
        fun getInstance(context:Context) : RoomUser_DataBase?{
            if(instance == null){
                synchronized(RoomUser_DataBase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoomUser_DataBase::class.java,
                        "roomuesr.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return instance
        }
    }
}