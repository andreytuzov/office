package io.office.domain.model

import io.office.domain.mapper.DateMapper
import java.util.*

data class Worker(
    val id: Long = 0,
    val name: String,
    val lastName: String,
    val avatarUri: String?,
    val birthday: Date?
) {
    private val dateMapper: DateMapper by lazy { DateMapper.Impl() }

    val age: String?
        get() = birthday?.run { dateMapper.mapAgeFrom(this) } ?: AGE_EMPTY_TEXT

    val birthdayText: String
        get() = birthday?.run { dateMapper.mapString(this) } ?: BIRTHDAY_EMPTY_TEXT

    companion object {
        private const val BIRTHDAY_EMPTY_TEXT = "-"
        private const val AGE_EMPTY_TEXT = "-"
    }
}