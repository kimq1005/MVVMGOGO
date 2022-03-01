package test.map.mvvmgogo.retrofit_MvvmPackage.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [TestEntity::class], version = 1)
abstract class TestDataBase : RoomDatabase() {
    abstract fun testDao() : TestDao

    companion object{

        private var INSTANCE : TestDataBase?=null

        fun getinstance(context: Context):TestDataBase?{

            if(INSTANCE==null){
                synchronized(TestDataBase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TestDataBase::class.java,
                        "test_db"
                    ).build()
                }
            }

            return INSTANCE
        }
    }
}