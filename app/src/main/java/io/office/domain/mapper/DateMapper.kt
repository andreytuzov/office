package io.office.domain.mapper

import android.annotation.SuppressLint
import android.text.format.DateUtils
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

interface DateMapper {

    fun mapAgeFrom(date: Date): String
    fun mapString(date: Date): String
    fun map(date: String): Date?

    @SuppressLint("SimpleDateFormat")
    class Impl @Inject constructor() : DateMapper {

        private val format by lazy { SimpleDateFormat(DATE_FORMAT) }

        override fun mapAgeFrom(date: Date): String {
            val age = (System.currentTimeMillis() - date.time) / DateUtils.YEAR_IN_MILLIS
            return age.toString()
        }

        override fun mapString(date: Date): String {
            return format.format(date)
        }

        override fun map(date: String): Date? {
            return date.parse("yyyy-MM-dd")
                ?: date.parse("dd-MM-yyyy")
        }

        @SuppressLint("SimpleDateFormat")
        private fun String?.parse(format: String): Date? {
            return try {
                SimpleDateFormat(format).parse(this)
            } catch (ex: Exception) {
                null
            }
        }

        companion object {
            private const val DATE_FORMAT = "dd.MM.yyyy"
        }
    }
}