package au.com.doan.qantas.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {
    @[Provides Singleton]
    fun provideApplication(): Application {
        return application
    }

    @[Provides Singleton]
    fun provideAppContext() : Context = application.applicationContext
}