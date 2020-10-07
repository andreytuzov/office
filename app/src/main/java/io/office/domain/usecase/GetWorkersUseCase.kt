package io.office.domain.usecase

import io.office.data.WorkersDataSource
import io.office.data.WorkersResult
import io.office.domain.WorkersRepository

interface GetWorkersUseCase {

    suspend fun getWorkers(): WorkersResult

    class Impl(
        val repository: WorkersRepository
    ) : GetWorkersUseCase {

        override suspend fun getWorkers(): WorkersResult {
            return repository.getWorkers()
        }
    }
}