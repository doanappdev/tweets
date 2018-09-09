package au.com.doan.qantas.base

import android.content.Context
import android.content.Intent
import org.jetbrains.anko.AnkoLogger

interface BaseContract {
    interface View

    interface Presenter<T : View> : AnkoLogger {
        var view : T
        fun attach(view : T)
        fun onStart() {}
        fun onStop() {}
        fun onDestroy() {}
        fun subscribe()
    }

}