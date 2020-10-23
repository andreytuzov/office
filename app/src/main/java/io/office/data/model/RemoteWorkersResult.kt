package io.office.data.model

import io.office.domain.model.WorkerWithSpecialities

sealed class RemoteWorkersResult {
    data class Success(val workers: List<WorkerWithSpecialities>): RemoteWorkersResult()
    object NetworkConnectionError : RemoteWorkersResult()
    object NotFoundException: RemoteWorkersResult()
}