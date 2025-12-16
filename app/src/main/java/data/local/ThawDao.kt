package com.example.pollopollito.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ThawDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(thaw: ThawEntity)

    @Query("SELECT * FROM thaws ORDER BY createdAtMillis DESC")
    fun observeAll(): Flow<List<ThawEntity>>
}
