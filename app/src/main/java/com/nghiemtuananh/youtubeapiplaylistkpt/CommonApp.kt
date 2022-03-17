package com.nghiemtuananh.youtubeapiplaylistkpt

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object CommonApp {
    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .error(R.drawable.ic_launcher_background)
            .placeholder(R.drawable.ic_launcher_background)
            .into(view)
    }
}