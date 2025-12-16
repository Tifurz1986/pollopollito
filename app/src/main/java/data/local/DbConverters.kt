package com.example.pollopollito.data.local

import androidx.room.TypeConverter
import com.example.pollopollito.domain.ChickenType

class DbConverters {

    @TypeConverter
    fun chickenTypeToString(value: ChickenType): String = value.name

    @TypeConverter
    fun stringToChickenType(value: String): ChickenType = ChickenType.valueOf(value)
}
