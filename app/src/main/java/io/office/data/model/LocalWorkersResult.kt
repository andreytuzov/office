package io.office.data.model

import io.office.domain.model.WorkerWithSpecialities

sealed class LocalWorkersResult {
    data class Success(val workers: List<WorkerWithSpecialities>): LocalWorkersResult()
    object NotFoundException: LocalWorkersResult()
}