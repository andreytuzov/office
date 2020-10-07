package io.office.data

import io.office.domain.model.Worker

sealed class WorkersResult {
    data class Success(val workers: List<Worker>): WorkersResult()
    object NetworkConnectionError : WorkersResult()
}