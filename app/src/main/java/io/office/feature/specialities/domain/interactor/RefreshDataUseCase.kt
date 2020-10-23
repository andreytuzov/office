package io.office.feature.specialities.domain.interactor

import io.office.domain.WorkersRepository
import io.office.domain.model.RefreshResult
import javax.inject.Inject

interface RefreshDataUseCase {

    suspend fun refreshData(): RefreshResult

    class Impl @Inject constructor(private val repository: WorkersRepository) : RefreshDataUseCase {
        override suspend fun refreshData(): RefreshResult {
            return repository.refreshData()
        }
    }
}