package com.nghiemtuananh.youtubeapiplaylistkpt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nghiemtuananh.youtubeapiplaylistkpt.databinding.RowVideoYoutubeBinding

class VideoYoutbeAdapter(var inter: IDataAndClick): RecyclerView.Adapter<VideoYoutbeAdapter.VideoYoutubeViewHolder>() {
    inner class VideoYoutubeViewHolder(var binding: RowVideoYoutubeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoYoutubeViewHolder {
        return VideoYoutubeViewHolder(RowVideoYoutubeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VideoYoutubeViewHolder, position: Int) {
        var videoYouTube = inter.getItem(position)
        holder.binding.data = videoYouTube
        holder.itemView.setOnClickListener {
            inter.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return inter.getCount()
    }
}

interface IDataAndClick {
    fun getCount(): Int
    fun getItem(position: Int): VideoYouTube
    fun onClick(position: Int)
}