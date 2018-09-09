package au.com.doan.qantas.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import au.com.doan.qantas.QantasApp
import au.com.doan.qantas.R
import au.com.doan.qantas.base.BaseItemView
import javax.inject.Inject

class MainActivity : AppCompatActivity(), TweetsContract.View {

    @Inject
    lateinit var presenter: TweetsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        QantasApp.appComponent.inject(this)
        presenter.attach(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when(ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            true -> { presenter.getTweets() }
            else -> { requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 888) }
        }

    }

    override fun showProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAdapter(viewItems: List<BaseItemView>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
