package io.office.speciality

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.office.domain.model.Worker

abstract class SpecialityViewModel : ViewModel() {

    abstract val workers: LiveData<List<Worker>>
    abstract val showError: LiveData<String>
    abstract val showLoading: LiveData<Unit>
    abstract val hideLoading: LiveData<Unit>
}