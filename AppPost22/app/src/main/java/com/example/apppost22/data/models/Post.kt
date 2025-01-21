package com.example.apppost22.data.models

data class Post (
    val id: Int,
    val title: String,
    val content: String,
    val owner_id : Int
)

data class CreatePostRequest(
    val title: String,
    val content: String
)