package io.office.db

import io.office.data.WorkersResult
import io.office.data.WorkersDataSource
import io.office.data.mappers.WorkersLocalMapper
import io.office.domain.model.Worker

class LocalWorkersDataSource(
    val workersDao: WorkersDao,
    val workersLocalMapper: WorkersLocalMapper
) : WorkersDataSource {

    override suspend fun isHasData(): Boolean {
        return workersDao.getCountWorkers() > 0
    }

    override suspend fun getWorkers(): WorkersResult {
        val workers = mutableListOf<Worker>()
        for (workerEntity in workersDao.getWorkers()) {
            val worker = workersLocalMapper.map(workerEntity, emptyList())
            workers.add(worker)
        }
        return WorkersResult.Success(workers)
    }

    override suspend fun saveWorkers(workers: List<Worker>) {
        val workerEntities = workers.map { workersLocalMapper.map(it) }
        workersDao.saveWorkers(workerEntities)
    }
}