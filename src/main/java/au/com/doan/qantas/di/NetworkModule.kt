package au.com.doan.qantas.di

import au.com.doan.qantas.service.TweetService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    //val BASE_URL = "http://assure-ios-dev.s3.amazonaws.com/ios-tech-test-data-qantas-twitter.zip"
    val BASE_URL = "http://assure-ios-dev.s3.amazonaws.com/"

    @[Provides Singleton]
    fun provideRetrofitBuilder() : Retrofit.Builder =
            Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())

    @[Provides Singleton]
    fun provideTweetsService(builder: Retrofit.Builder) : TweetService = builder
            .baseUrl(BASE_URL)
            .build()
            .create(TweetService::class.java)

}