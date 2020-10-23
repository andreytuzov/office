package io.office.domain.model

sealed class RefreshResult {
    object Success: RefreshResult()
    object NetworkConnectionError : RefreshResult()
}