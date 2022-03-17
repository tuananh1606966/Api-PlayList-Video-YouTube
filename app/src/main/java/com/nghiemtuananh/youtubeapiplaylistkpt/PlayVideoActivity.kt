package com.nghiemtuananh.youtubeapiplaylistkpt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_play_video.*

class PlayVideoActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    var id = ""
    val REQUEST_VIDEO = 12
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)
        id = intent.getStringExtra("idVideo") as String
        myYoutube.initialize(MainActivity.API_KEY, this)
    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean,
    ) {
        p1?.loadVideo(id)
        p1?.setFullscreen(true)
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?,
    ) {
        if (p1!!.isUserRecoverableError) {
            p1.getErrorDialog(this, REQUEST_VIDEO)
        } else {
            Toast.makeText(this, "Error!!!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_VIDEO) {
            myYoutube.initialize(MainActivity.API_KEY, this)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}