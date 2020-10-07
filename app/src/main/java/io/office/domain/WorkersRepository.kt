package io.office.domain

import io.office.data.WorkersResult
import io.office.domain.model.Worker

interface WorkersRepository {

    suspend fun getWorkers(): WorkersResult
    suspend fun saveWorkers(workers: List<Worker>)
}