package io.office.feature.specialities.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.office.domain.model.Speciality

abstract class SpecialitiesViewModel : ViewModel() {

    abstract val specialities: LiveData<List<Speciality>>
    abstract fun onSpecialityClicked(speciality: Speciality)
}