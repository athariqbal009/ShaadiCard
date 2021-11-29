package com.android.data.remote.models


import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)