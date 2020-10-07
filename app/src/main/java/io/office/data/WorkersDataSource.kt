package io.office.data

import io.office.domain.model.Worker

interface WorkersDataSource {

    suspend fun isHasData(): Boolean
    suspend fun getWorkers(): WorkersResult
    suspend fun saveWorkers(workers: List<Worker>)
}