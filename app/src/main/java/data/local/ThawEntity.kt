package com.example.pollopollito.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pollopollito.domain.ChickenType

@Entity(tableName = "thaws")
data class ThawEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,

    val chickenType: ChickenType,
    val bolsas: Int,

    val userId: String,      // "CR" en v0.1
    val initials: String,    // "CR" en v0.1

    val createdAtMillis: Long = System.currentTimeMillis()
)
