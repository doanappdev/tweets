package au.com.doan.qantas.di

import android.util.Log
import au.com.doan.qantas.service.TweetService
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton

@Module
class NetworkModule {

    //val BASE_URL = "http://assure-ios-dev.s3.amazonaws.com/ios-tech-test-data-qantas-twitter.zip/"
    val BASE_URL = "http://assure-ios-dev.s3.amazonaws.com/"

    @[Provides Singleton]
    fun provideRetrofitBuilder() : Retrofit.Builder =
            Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())

    @[Provides Singleton]
    fun provideTweetsService(builder: Retrofit.Builder) : TweetService {
        val httpClient = OkHttpClient.Builder()
                // disable HTTPS??
//                .connectionSpecs(arrayListOf(
//                    ConnectionSpec.MODERN_TLS,
//                    ConnectionSpec.COMPATIBLE_TLS))
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()

        return builder.client(httpClient)
                .baseUrl(BASE_URL)
                .build()
                .create(TweetService::class.java)
    }
}