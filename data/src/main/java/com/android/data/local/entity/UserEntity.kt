package com.android.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id:Int? = null,
    @ColumnInfo(name = "name") val name:String?,
    @ColumnInfo(name = "age") val age:Int?,
    @ColumnInfo(name = "address") val address:String?,
    @ColumnInfo(name = "url") val url:String?,
    @ColumnInfo(name = "status") val status:String
)