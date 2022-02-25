package test.map.mvvmgogo.room_Package

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class RoomUser(
    var name : String,
    var age : String,

//    @Embedded
//    var roomuserdata : RoomUserdata?
){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}

//
//data class RoomUserdata(
//
//    var phone:String,
//    var address:String
//)