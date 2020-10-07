package io.office.data.mappers

import io.office.api.response.WorkerResponse
import io.office.domain.model.Worker

interface WorkersRepositoryMapper {

    fun map(response: WorkerResponse): Worker

    class Impl : WorkersRepositoryMapper {

        override fun map(response: WorkerResponse): Worker {
            return Worker(
                    name = response.name,
                    lastName = response.lastName,
                    avatarUri = response.avatarUrl,
                    birthday = response.birthday,
                    specialityIds = response.specialities.map { it.id }
            )
        }
    }

}