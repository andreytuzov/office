package io.office.api

import io.office.data.WorkersDataSource
import io.office.data.WorkersResult
import io.office.data.mappers.WorkersRepositoryMapper
import io.office.domain.model.Worker
import java.io.IOException

class ApiWorkersDataSource(
    private val remoteApi: WorkersEndpoint,
    private val workersRepositoryMapper: WorkersRepositoryMapper
) : WorkersDataSource {

    override suspend fun isHasData() = false

    override suspend fun getWorkers(): WorkersResult {
        return try {
            val response = remoteApi.getWorkers()
            val workers = response.workers.map(workersRepositoryMapper::map)
            return WorkersResult.Success(workers)
        } catch (ex: IOException) {
            WorkersResult.NetworkConnectionError
        }
    }

    override suspend fun saveWorkers(workers: List<Worker>) {
    }
}