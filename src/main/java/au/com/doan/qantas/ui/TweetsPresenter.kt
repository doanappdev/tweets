package au.com.doan.qantas.ui

import android.os.Environment
import au.com.doan.qantas.base.BaseItemView
import au.com.doan.qantas.repository.TweetRepository
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import android.os.Environment.DIRECTORY_DOWNLOADS
import android.os.Environment.getExternalStoragePublicDirectory
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream


class TweetsPresenter constructor(val repository: TweetRepository) : TweetsContract.Presenter, AnkoLogger {

    override lateinit var view: TweetsContract.View

    private var photoViewItems = mutableListOf<BaseItemView>()

    private var totalFileSize = 0


    override fun attach(view: TweetsContract.View) {
        this.view = view
    }


    override fun subscribe() {}

    override fun getTweets() {
        repository.getTweets()
                .subscribe {
                    info { "zip : ${it.contentType()}" }
                    info { "bytes : ${it.bytes()}" }

                    var count: Int
                    val data = ByteArray(1024 * 4)
                    val fileSize = it.contentLength()
                    val bis = BufferedInputStream(it.byteStream(), 1024 * 8)
                    val outputFile = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "file.zip")
                    val output = FileOutputStream(outputFile)
                    var total: Long = 0
                    val startTime = System.currentTimeMillis()
                    var timeCount = 1
                    count = bis.read(data)
                    while (count != -1) {

                        total += count.toLong()
                        totalFileSize = (fileSize / Math.pow(1024.0, 2.0)).toInt()
                        val current = Math.round(total / Math.pow(1024.0, 2.0)).toDouble()

                        val progress = (total * 100 / fileSize).toInt()

                        val currentTime = System.currentTimeMillis() - startTime

                        //val download = Download()
                        //download.setTotalFileSize(totalFileSize)

//                        if (currentTime > 1000 * timeCount) {
//
//                            download.setCurrentFileSize(current.toInt())
//                            download.setProgress(progress)
//                            //sendNotification(download)
//                            timeCount++
//                        }

                        output.write(data, 0, count)
                        count = bis.read(data)
                    }
                    //onDownloadComplete()
                    output.flush()
                    output.close()
                    bis.close()

                }
    }
}