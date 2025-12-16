package com.example.pollopollito.data.repository

import com.example.pollopollito.data.local.ThawDao
import com.example.pollopollito.data.local.ThawEntity
import kotlinx.coroutines.flow.Flow

class ThawRepository(private val dao: ThawDao) {

    fun observeAll(): Flow<List<ThawEntity>> = dao.observeAll()

    suspend fun insert(thaw: ThawEntity) {
        dao.insert(thaw)
    }
}
