package test.map.mvvmgogo.retrofit_MvvmPackage.roomDB

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TestRoomViewModel(application: Application):AndroidViewModel(application) {

    private val repository = TestRepository(application)

    private val _testEntity = MutableLiveData<List<TestEntity>>()
    val testEntity : LiveData<List<TestEntity>>
        get() = _testEntity

    init {

    }

    fun getAllstation() : LiveData<List<TestEntity>>{
        return repository.getAll()

    }

    fun addStation(name:String){
        val stationame = TestEntity(null,name)

        CoroutineScope(Dispatchers.IO).launch {
            repository.inert(stationame)
        }
    }



    fun deleteStation(testEntity: TestEntity){
        CoroutineScope(Dispatchers.IO).launch {
            repository.delete(testEntity)
        }
    }


    // 뷰모델에 파라미터를 넘기기위해 파라미터를 포함한 객체생성
    class Factory(val application: Application) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TestRoomViewModel(application) as T
        }
    }


}