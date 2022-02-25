package test.map.mvvmgogo.room_Package

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface RoomUserDao {

    @Insert(onConflict = REPLACE)
    fun insert(roomuser : RoomUser)

    @Update
    fun update(roomuser : RoomUser)

    @Delete
    fun delete(roomuser : RoomUser)

    @Query("SELECT * FROM RoomUser")
    fun getAll() : LiveData<List<RoomUser>>

    @Query("DELETE FROM RoomUser ")
    fun deleteAll()
}