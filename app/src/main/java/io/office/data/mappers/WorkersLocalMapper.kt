package io.office.data.mappers

import io.office.db.entity.WorkerEntity
import io.office.domain.model.Worker

interface WorkersLocalMapper {

    fun map(entity: WorkerEntity, specialityIds: List<Long>): Worker
    fun map(worker: Worker): WorkerEntity

    class Impl : WorkersLocalMapper {
        override fun map(entity: WorkerEntity, specialityIds: List<Long>): Worker {
            return Worker(
                name = entity.name,
                lastName = entity.lastName,
                avatarUri = entity.avatarUri,
                birthday = entity.birthday,
                specialityIds = specialityIds.map { it.toInt() }
            )
        }

        override fun map(worker: Worker): WorkerEntity {
            return WorkerEntity(
                id = 0,
                name = worker.name,
                lastName = worker.lastName,
                avatarUri = worker.avatarUri,
                birthday = worker.birthday
            )
        }
    }
}