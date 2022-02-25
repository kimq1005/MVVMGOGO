package test.map.mvvmgogo.room_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import test.map.mvvmgogo.Utils.Companion.TAG
import test.map.mvvmgogo.databinding.ActivityRoomMvvmMainBinding

class RoomMvvm_MainActivity : AppCompatActivity() {

    private var roomMvvmMainBinding: ActivityRoomMvvmMainBinding? = null
    private val binding get() = roomMvvmMainBinding!!

    private lateinit var db: RoomUser_DataBase
    private lateinit var roomUserviewmodel: Room_UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roomMvvmMainBinding = ActivityRoomMvvmMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        db = RoomUser_DataBase.getInstance(this)!!
////        fetchUserList()
//
//        db.roomUserDao().getAll().observe(this, Observer {
//            updateUserList(it)
//        })

        roomUserviewmodel = ViewModelProvider(this, Room_UserViewModel.Factory(application)).get(Room_UserViewModel::class.java)

        binding.roomuserViewModel = roomUserviewmodel


        roomUserviewmodel.getAll().observe(this, Observer {
            updateUserList(it)
        })

    }

    private fun updateUserLis22t(userList: List<RoomUser>) {

        var userListText = "사용자 목록"

        CoroutineScope(Dispatchers.Main).launch {
            val load = async(Dispatchers.IO) {
                for (i in userList) {
                    userListText += "\n${i.id} ${i.name} ${i.age}"
                }
            }

            load.await()
            binding.textview.text = userListText
        }
    }

    private fun updateUserList(userList: List<RoomUser>) {

        var userListText = "사용자 목록"

        for(i in userList){
            userListText += "\n${i.id} ${i.name} ${i.age}"
        }

        binding.textview.text = userListText
    }


    private fun addUser() {
        val nametext = binding.nameeditTextView.text.toString()
        val agetext = binding.ageeditTextView.text.toString()

        val user = RoomUser(nametext, agetext)

        CoroutineScope(Dispatchers.IO).launch {
            db.roomUserDao().insert(user)
        }

    }


    private fun deleteAllUser() {
        CoroutineScope(Dispatchers.Main).launch {
            val delete = async(Dispatchers.IO) {
                db.roomUserDao().deleteAll()
            }
            delete.await()
        }
    }
}