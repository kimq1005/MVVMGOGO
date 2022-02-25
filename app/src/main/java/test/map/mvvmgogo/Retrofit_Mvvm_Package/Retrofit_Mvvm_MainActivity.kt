package test.map.mvvmgogo.Retrofit_Mvvm_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Response
import test.map.mvvmgogo.Retrofit_Mvvm_Package.retrofit.Retrofit_Client
import test.map.mvvmgogo.Retrofit_Mvvm_Package.retrofit.Retrofit_InterFace
import test.map.mvvmgogo.Utils.Companion.TAG
import test.map.mvvmgogo.databinding.ActivityRetrofitMvvmMainBinding

class Retrofit_Mvvm_MainActivity : AppCompatActivity() {

    private var retrofitMvvmMainBinding:ActivityRetrofitMvvmMainBinding?=null
    private val binding get() = retrofitMvvmMainBinding!!


    private var retrofitInterface: Retrofit_InterFace = Retrofit_Client.getClient("http://openapi.tago.go.kr/openapi/service/").create(Retrofit_InterFace::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retrofitMvvmMainBinding = ActivityRetrofitMvvmMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerview("31010","우남")

    }

    private fun setRecyclerview(citycode: String, stationName: String?) {
        val  stationcall = retrofitInterface.StationNameGet(citycode,stationName,null)

        stationcall.enqueue(object:retrofit2.Callback<StationBus>{
            override fun onResponse(call: Call<StationBus>, response: Response<StationBus>) {
                val body = response.body()
                Log.d(TAG, "onResponse: $body")
            }

            override fun onFailure(call: Call<StationBus>, t: Throwable) {
                Log.d(TAG, "onFailure: $t")
            }

        })
    }
}