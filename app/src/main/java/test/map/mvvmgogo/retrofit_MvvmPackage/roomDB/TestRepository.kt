package test.map.mvvmgogo.retrofit_MvvmPackage.roomDB

import android.app.Application
import androidx.lifecycle.LiveData

class TestRepository(application: Application) {

    private val testdao : TestDao
    private val stationList : LiveData<List<TestEntity>>

    init{
        var db : TestDataBase = TestDataBase.getinstance(application)!!
        testdao = db!!.testDao()
        stationList = db.testDao().stationgetAll()
    }


   fun inert(testEntity: TestEntity){
        testdao.addStation(testEntity)
    }

    fun getAll() : LiveData<List<TestEntity>>{
        return testdao.stationgetAll()
    }

    fun delete(testEntity: TestEntity){
        testdao.delete(testEntity)
    }

}