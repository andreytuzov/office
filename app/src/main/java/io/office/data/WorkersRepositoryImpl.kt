package io.office.data

import io.office.domain.WorkersRepository
import io.office.domain.model.Worker

class WorkersRepositoryImpl(
        val onlineDataSource: WorkersDataSource,
        val localDataSource: WorkersDataSource
) : WorkersRepository {

    override suspend fun getWorkers(): WorkersResult {
        if (localDataSource.isHasData()) {
            return localDataSource.getWorkers()
        }
        val workersResult = onlineDataSource.getWorkers()
        if (workersResult is WorkersResult.Success) {
           localDataSource.saveWorkers(workersResult.workers)
        }
        return workersResult
    }

    override suspend fun saveWorkers(workers: List<Worker>) {
        localDataSource.saveWorkers(workers)
    }
}