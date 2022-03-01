package test.map.mvvmgogo.retrofit_MvvmPackage.roomDB

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "test_table")
data class TestEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int?,

    val stationname:String

)

