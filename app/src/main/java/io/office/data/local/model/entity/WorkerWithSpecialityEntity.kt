package io.office.data.local.model.entity

import androidx.room.Entity
import androidx.room.Index

@Entity(tableName = "worker_with_speciality", primaryKeys = ["workerId", "specialityId"], indices = [
    Index(value = ["workerId"]), Index(value = ["specialityId"])
])
data class WorkerWithSpecialityEntity(
    val workerId: Long,
    val specialityId: Long
)