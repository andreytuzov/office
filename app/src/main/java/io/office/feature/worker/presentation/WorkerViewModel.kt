package io.office.feature.worker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.office.domain.model.Speciality
import io.office.domain.model.WorkerWithSpecialities

abstract class WorkerViewModel: ViewModel() {
    abstract fun getWorker(workerId: Long): LiveData<WorkerWithSpecialities>
    abstract fun onSpecialityClicked(speciality: Speciality)
}