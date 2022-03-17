package com.nghiemtuananh.youtubeapiplaylistkpt

import com.google.gson.annotations.SerializedName

data class DataVideoResponse(
    var items: ArrayList<Item>
)

data class Item(
    var snippet: Snippet
)

data class Snippet(
    var title: String,
    var thumbnails: Thumbnails,
    var resourceId: ResourceId
)

data class Thumbnails(
    var medium: MediumThumbnails
)

data class MediumThumbnails(
    var url: String
)

data class ResourceId(
    var videoId: String
)
