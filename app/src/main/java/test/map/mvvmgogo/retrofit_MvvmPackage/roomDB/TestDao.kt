package test.map.mvvmgogo.retrofit_MvvmPackage.roomDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query


@Dao
interface TestDao {

    @Insert(onConflict = REPLACE)
    fun addStation(testEntity: TestEntity)


    @Query("SELECT * FROM test_table")
    fun stationgetAll() : LiveData<List<TestEntity>>

    @Delete
    fun delete(testEntity: TestEntity)
}