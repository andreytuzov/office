package io.office.data.local.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import io.office.data.local.WorkerTypeConverters
import java.util.*

@Entity(tableName = "worker")
@TypeConverters(WorkerTypeConverters::class)
data class WorkerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "avatar_uri")
    val avatarUri: String?,
    @ColumnInfo(name = "birthday")
    val birthday: Date?
)