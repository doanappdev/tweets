package au.com.doan.qantas

import android.app.Application
import au.com.doan.qantas.di.*

class QantasApp : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .build()

        // if we want to inject objects into this class uncomment this
        //appComponent.inject(this)
    }
}