package com.example.asonbom.data.responses

import com.example.asonbom.data.models.Post
import com.google.gson.annotations.SerializedName

data class PostsResponse(
    @SerializedName("status_code")
    var status:Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("posts")
    var posts: List<Post>
)