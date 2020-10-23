package io.office.data

import io.office.data.model.RemoteWorkersResult

interface RemoteWorkersDataSource {
    suspend fun getWorkers(): RemoteWorkersResult
}