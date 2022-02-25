package test.map.mvvmgogo.mvvm_RecyclerView_Package

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun todoDao() : TodoDao

    companion object{
        private var instance:AppDatabase?=null


        @Synchronized
        fun getInstance(context:Context):AppDatabase?{

            if(instance==null){
                synchronized(AppDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "database-name"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return instance
        }
    }
}