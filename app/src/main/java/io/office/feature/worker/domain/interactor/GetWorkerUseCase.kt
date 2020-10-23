package io.office.feature.worker.domain.interactor

import androidx.lifecycle.LiveData
import io.office.domain.WorkersRepository
import io.office.domain.model.WorkerWithSpecialities
import javax.inject.Inject

interface GetWorkerUseCase {

    fun getWorker(id: Long): LiveData<WorkerWithSpecialities>

    class Impl @Inject constructor(val repository: WorkersRepository) : GetWorkerUseCase {
        override fun getWorker(id: Long): LiveData<WorkerWithSpecialities> {
            return repository.getWorker(id)
        }
    }
}