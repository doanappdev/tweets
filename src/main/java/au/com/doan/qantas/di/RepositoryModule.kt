package au.com.doan.qantas.di

import au.com.doan.qantas.repository.TweetRepository
import au.com.doan.qantas.repository.TweetRepositoryImpl
import au.com.doan.qantas.service.TweetService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @[Provides Singleton]
    fun provideTweetRepository(service: TweetService) : TweetRepository = TweetRepositoryImpl(service)
}