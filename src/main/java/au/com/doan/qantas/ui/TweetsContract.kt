package au.com.doan.qantas.ui

import au.com.doan.qantas.base.BaseContract
import au.com.doan.qantas.base.BaseItemView
import org.jetbrains.anko.AnkoLogger

interface TweetsContract {
    interface View : BaseContract.View, AnkoLogger {
        fun showProgressBar()
        fun hideProgressBar()
        fun setAdapter(viewItems: List<BaseItemView>)
    }


    interface Presenter : BaseContract.Presenter<View> {
        fun getTweets()
    }
}