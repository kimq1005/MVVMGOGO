package test.map.mvvmgogo.Retrofit_Mvvm_Package

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Retrofit_MainViewModel:ViewModel() {

    private val _StationBus = MutableLiveData<ArrayList<StationBus>>()

    private var items = ArrayList<StationBus>()

    val stationbus:LiveData<ArrayList<StationBus>> get() = _StationBus

    init {
        items

        _StationBus.value = items
    }


}