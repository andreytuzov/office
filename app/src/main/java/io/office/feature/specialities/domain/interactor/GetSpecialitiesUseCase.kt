package io.office.feature.specialities.domain.interactor

import androidx.lifecycle.LiveData
import io.office.domain.WorkersRepository
import io.office.domain.model.Speciality
import javax.inject.Inject

interface GetSpecialitiesUseCase {

    fun getSpecialities(): LiveData<List<Speciality>>

    class Impl @Inject constructor(private val repository: WorkersRepository) : GetSpecialitiesUseCase {
        override fun getSpecialities(): LiveData<List<Speciality>> {
            return repository.getSpeciality()
        }
    }
}