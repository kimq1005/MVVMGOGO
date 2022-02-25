package test.map.mvvmgogo.Retrofit_Mvvm_Package.retrofit

import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit

object Retrofit_Client {

    fun getClient(baseurl: String): Retrofit {

        val client = OkHttpClient.Builder()

        val baseInterceptor: Interceptor = (object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {

                val realRequest = chain.request()

                val goaddurl = realRequest
                    .url()
                    .newBuilder()
                    .addQueryParameter("serviceKey", "BnKpptblxm79eSvEL6NLbbs89Uo4iaKvI4NviHONPrOtzfK5cUHTra3VnfLoyDIGe221nM/W1rlkODmDxc0D9w==")
                    .build()

                val lastRequest = realRequest.newBuilder()
                    .url(goaddurl)
                    .build()

                return chain.proceed(lastRequest)
            }

        })

        client.addInterceptor(baseInterceptor)

        val retrofitClient = Retrofit.Builder()
            .baseUrl(baseurl)
            .client(client.build())
            .addConverterFactory(
                TikXmlConverterFactory.create(
                    TikXml.Builder().exceptionOnUnreadXml(false).build()
                )
            )
            .build()

        return retrofitClient

    }
}