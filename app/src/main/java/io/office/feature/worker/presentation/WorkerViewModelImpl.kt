package io.office.feature.worker.presentation

import androidx.lifecycle.LiveData
import io.office.feature.worker.domain.interactor.GetWorkerUseCase
import io.office.domain.model.Speciality
import io.office.domain.model.WorkerWithSpecialities
import io.office.navigation.Destination
import io.office.navigation.Router
import javax.inject.Inject

class WorkerViewModelImpl @Inject constructor(
    private val getWorkerUseCase: GetWorkerUseCase,
    private val router: Router
) : WorkerViewModel() {

    override fun getWorker(workerId: Long): LiveData<WorkerWithSpecialities> {
        return getWorkerUseCase.getWorker(workerId)
    }

    override fun onSpecialityClicked(speciality: Speciality) {
        router.goto(Destination.Speciality(speciality.id))
    }
}