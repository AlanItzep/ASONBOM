package com.example.asonbom.data.models

import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var title: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("content")
    var content: String
)


