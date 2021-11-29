package com.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.data.local.dao.UserDAO
import com.android.data.local.entity.UserEntity

private const val DATABASE_VERSION = 1

@Database(
    entities = [UserEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDAO(): UserDAO
}