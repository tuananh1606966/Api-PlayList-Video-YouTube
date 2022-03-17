package com.nghiemtuananh.youtubeapiplaylistkpt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IDataAndClick {
    companion object{
        val API_KEY = "AIzaSyDCaqa5p_RFzJYesIw7kJ_zzPmvFV8zjfA"
    }
    val ID_PLAYLIST = "PL3sbkPMpiXbbmir8DEi5ubwl9b-mwGEmW"
    var listVideo: ArrayList<VideoYouTube> = arrayListOf()
    lateinit var adapter: VideoYoutbeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getApi()
        adapter = VideoYoutbeAdapter(this)
        rcv_video.adapter = adapter
        rcv_video.layoutManager = LinearLayoutManager(this)
        rcv_video.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun getApi() {
        var obs: Observable<DataVideoResponse> = VideoFactor.createRetrofit()
            .getYoutubeVideo(API_KEY, ID_PLAYLIST, "snippet", 50)
        obs.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    for (i in 0..it.items.size - 1) {
                        listVideo.add(VideoYouTube(it.items[i].snippet.title, it.items[i].snippet.thumbnails.medium.url, it.items[i].snippet.resourceId.videoId))
                    }
                },
                {},
                {
                    adapter.notifyDataSetChanged()
                }
            )
    }

    override fun onClick(position: Int) {
        intent = Intent(this, PlayVideoActivity::class.java)
        intent.putExtra("idVideo", listVideo[position].idVideo)
        startActivity(intent)
    }

    override fun getCount(): Int {
        return listVideo.size
    }

    override fun getItem(position: Int): VideoYouTube {
        return listVideo.get(position)
    }
}