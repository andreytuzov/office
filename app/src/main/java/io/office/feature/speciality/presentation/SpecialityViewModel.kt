package io.office.feature.speciality.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.office.domain.model.SpecialityWithWorkers
import io.office.domain.model.Worker

abstract class SpecialityViewModel : ViewModel() {
    abstract fun loadSpeciality(id: Long): LiveData<SpecialityWithWorkers>
    abstract fun onWorkerClicked(worker: Worker)
}