package au.com.doan.qantas.di

import au.com.doan.qantas.repository.TweetRepository
import au.com.doan.qantas.ui.TweetsContract
import au.com.doan.qantas.ui.TweetsPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @[Provides Singleton]
    fun provideTweetPresenter(repository: TweetRepository) : TweetsContract.Presenter = TweetsPresenter(repository)
}