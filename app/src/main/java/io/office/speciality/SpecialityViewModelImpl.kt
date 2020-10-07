package io.office.speciality

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.office.domain.usecase.GetWorkersUseCase
import io.office.helpers.SingleLiveEvent
import io.office.domain.model.Worker
import io.office.data.WorkersResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpecialityViewModelImpl(
    private val getWorkersUseCase: GetWorkersUseCase
) : SpecialityViewModel() {

    override val workers = MutableLiveData<List<Worker>>()
    override val showError = SingleLiveEvent<String>()
    override val showLoading = SingleLiveEvent<Unit>()
    override val hideLoading = SingleLiveEvent<Unit>()

    init {
        viewModelScope.launch {
            showLoading.call()
            val workersResult = getWorkersUseCase.getWorkers()
            hideLoading.call()
            handleResult(workersResult)
        }
    }

    private fun handleResult(workersResult: WorkersResult) =
        when (workersResult) {
            is WorkersResult.Success -> workers.value = workersResult.workers
            WorkersResult.NetworkConnectionError -> showError.value = "Network exception"
        }
}