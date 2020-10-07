package io.office.db.entity

import androidx.room.Entity

@Entity(tableName = "worker_with_speciality", primaryKeys = ["workerId", "specialityId"])
data class WorkerWithSpecialityEntity(
    val workerId: Long,
    val specialityId: Long
)