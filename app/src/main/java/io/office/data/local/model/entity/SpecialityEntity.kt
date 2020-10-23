package io.office.data.local.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "speciality")
data class SpecialityEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "name")
    val name: String
)