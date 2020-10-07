package io.office.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "worker")
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
    val birthday: String?
)