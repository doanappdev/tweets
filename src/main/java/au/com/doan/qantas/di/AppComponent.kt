package au.com.doan.qantas.di

import au.com.doan.qantas.ui.MainActivity
import au.com.doan.qantas.QantasApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    PresenterModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: QantasApp) : Builder
        fun appModule(appModule: AppModule) : Builder
        fun networkModule(networkModule: NetworkModule) : Builder
        fun repositoryModule(repositoryModule: RepositoryModule) : Builder
        fun presenterModule(presenterModule: PresenterModule) : Builder
        fun build() : AppComponent
    }

    fun inject(mainActivity: MainActivity)
}