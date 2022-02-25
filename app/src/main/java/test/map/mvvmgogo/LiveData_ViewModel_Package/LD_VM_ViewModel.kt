package test.map.mvvmgogo.LiveData_ViewModel_Package

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class actionType {
    Plus,
    MINUS

}

class LD_VM_ViewModel:ViewModel() {

    private val _currentValue = MutableLiveData<Int>()


    //실제로 보여지는 변수
    val currentValue : LiveData<Int>
        get() = _currentValue

    init {
        _currentValue.value = 0
    }


    fun UpdataValue(type:actionType, int:Int){
        when(type){
            actionType.Plus->{
                _currentValue.value = _currentValue.value?.plus(int)
            }

            actionType.MINUS->{
                _currentValue.value = _currentValue.value?.minus(int)
            }
        }

    }

}