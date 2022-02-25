package test.map.mvvmgogo.mvvm_RecyclerView_Package

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Todo(
    var content: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

