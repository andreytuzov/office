package io.office.feature.specialities.presentation

import androidx.lifecycle.viewModelScope
import io.office.feature.specialities.domain.interactor.GetSpecialitiesUseCase
import io.office.feature.specialities.domain.interactor.RefreshDataUseCase
import io.office.domain.model.Speciality
import io.office.navigation.Destination
import io.office.navigation.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SpecialitiesViewModelImpl @Inject constructor(
    getSpecialitiesUseCase: GetSpecialitiesUseCase,
    private val refreshDataUseCase: RefreshDataUseCase,
    private val router: Router
) : SpecialitiesViewModel() {

    override val specialities = getSpecialitiesUseCase.getSpecialities()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                refreshDataUseCase.refreshData()
            }
        }
    }

    override fun onSpecialityClicked(speciality: Speciality) {
        router.goto(Destination.Speciality(speciality.id))
    }
}