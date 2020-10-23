package io.office.feature.speciality.presentation

import androidx.lifecycle.LiveData
import io.office.feature.speciality.domain.interactor.GetSpecialityUseCase
import io.office.domain.model.SpecialityWithWorkers
import io.office.domain.model.Worker
import io.office.navigation.Destination
import io.office.navigation.Router
import javax.inject.Inject

class SpecialityViewModelImpl @Inject constructor(
    private val loadSpecialityUseCase: GetSpecialityUseCase,
    private val router: Router
) : SpecialityViewModel() {

    override fun loadSpeciality(id: Long): LiveData<SpecialityWithWorkers> {
        return loadSpecialityUseCase.getSpeciality(id)
    }

    override fun onWorkerClicked(worker: Worker) {
        router.goto(Destination.Worker(worker.id))
    }
}