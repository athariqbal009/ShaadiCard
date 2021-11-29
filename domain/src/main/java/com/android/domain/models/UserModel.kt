package com.android.domain.models

data class UserModel(
    val id: Int? = null,
    val imageUrl: String?,
    val fullName: String?,
    val age: Int?,
    val city: String? = "",
    val state: String? = "",
    val country: String? = "",
    val address: String?,
    val status: String = ""
)