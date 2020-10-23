package io.office.data.local.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import io.office.data.local.model.entity.SpecialityEntity
import io.office.data.local.model.entity.WorkerEntity
import io.office.data.local.model.entity.WorkerWithSpecialityEntity

data class WorkerWithSpecialitiesModel(
    @Embedded
    val worker: WorkerEntity,
    @Relation(entityColumn = "id", parentColumn = "id", associateBy = Junction(value = WorkerWithSpecialityEntity::class,
        parentColumn = "workerId", entityColumn = "specialityId"))
    val specialities: List<SpecialityEntity>
)