package au.com.doan.qantas.repository

import au.com.doan.qantas.service.TweetService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody


interface TweetRepository {
    fun getTweets() : Observable<ResponseBody>
}

class TweetRepositoryImpl(private val service: TweetService) : TweetRepository {

    override fun getTweets(): Observable<ResponseBody> {
        return service.getTweets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}