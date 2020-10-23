package io.office.feature.speciality.domain.interactor

import androidx.lifecycle.LiveData
import io.office.domain.WorkersRepository
import io.office.domain.model.SpecialityWithWorkers
import javax.inject.Inject

interface GetSpecialityUseCase {

    fun getSpeciality(id: Long): LiveData<SpecialityWithWorkers>

    class Impl @Inject constructor(val repository: WorkersRepository) : GetSpecialityUseCase {
        override fun getSpeciality(id: Long): LiveData<SpecialityWithWorkers> {
            return repository.getSpeciality(id)
        }
    }
}