package com.nghiemtuananh.youtubeapiplaylistkpt

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GetApiVideo {
    @GET("youtube/v3/playlistItems")
    fun getYoutubeVideo(
        @Query("key") apiKey: String,
        @Query("playlistId") channelId: String,
        @Query("part") videoPart: String,
        @Query("maxResults") maxResults: Int
    ): Observable<DataVideoResponse>
}