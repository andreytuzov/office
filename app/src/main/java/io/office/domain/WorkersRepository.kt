package io.office.domain

import androidx.lifecycle.LiveData
import io.office.domain.model.RefreshResult
import io.office.domain.model.Speciality
import io.office.domain.model.SpecialityWithWorkers
import io.office.domain.model.WorkerWithSpecialities

interface WorkersRepository {
    suspend fun refreshData(): RefreshResult
    fun getSpeciality(): LiveData<List<Speciality>>
    fun getWorker(id: Long): LiveData<WorkerWithSpecialities>
    fun getSpeciality(id: Long): LiveData<SpecialityWithWorkers>
}