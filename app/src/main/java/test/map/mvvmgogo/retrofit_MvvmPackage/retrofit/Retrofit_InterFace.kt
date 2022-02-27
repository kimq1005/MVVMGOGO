package test.map.mvvmgogo.retrofit_MvvmPackage.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import test.map.mvvmgogo.retrofit_MvvmPackage.StationBus


interface Retrofit_InterFace {


    @GET("BusSttnInfoInqireService/getSttnNoList")
    fun StationNameGet(
        @Query("cityCode") cityCode:String,
        @Query("nodeNm") staionName:String?,
        @Query("nodeNo") nodeNo:String?
    ) : Call<StationBus>
}