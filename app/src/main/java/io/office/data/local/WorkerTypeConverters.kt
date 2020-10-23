package io.office.data.local

import androidx.room.TypeConverter
import java.util.*

object WorkerTypeConverters {

    @JvmStatic
    @TypeConverter
    fun fromDate(date: Date?) = date?.time

    @JvmStatic
    @TypeConverter
    fun toDate(date: Long?) = date?.let(::Date)
}