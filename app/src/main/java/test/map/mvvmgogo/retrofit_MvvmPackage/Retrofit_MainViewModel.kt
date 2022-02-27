package test.map.mvvmgogo.retrofit_MvvmPackage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Retrofit_MainViewModel : ViewModel() {

    private val _stationItem = MutableLiveData<List<StationItem>>()

    val stationItem : LiveData<List<StationItem>>
        get() = _stationItem


    //retrofit data viewModel연결
    fun setStationBusItem(list : List<StationItem>){
        _stationItem.value = list
    }


}