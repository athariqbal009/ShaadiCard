package com.android.data.local.dao

import androidx.room.*
import com.android.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUsers(user: List<UserEntity>): List<Long>

    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>

    @Query("UPDATE users SET status = :status WHERE id = :id")
    suspend fun updateUser(id: Int, status: String): Int
}