package test.map.mvvmgogo.recycler_package

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //그럼 이게 Entity가 되겠고
    private val _userProfileList = MutableLiveData<ArrayList<UserProfiles>>()

    val userProfilesList: LiveData<ArrayList<UserProfiles>>
        get() = _userProfileList


    private var items = ArrayList<UserProfiles>()

    init{
        items = arrayListOf(
            UserProfiles("김승현",27),
            UserProfiles("rrrrr",3022)
        )

        _userProfileList.value = items
    }

    fun buttonClick(){
        val userProfiles = UserProfiles("Test",20)
        items.add(userProfiles)
        _userProfileList.value = items
    }
}