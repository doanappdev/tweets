package au.com.doan.qantas.service

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

interface TweetService {
    @GET("ios-tech-test-data-qantas-twitter.zip")
    fun getTweets() : Observable<ResponseBody>
}