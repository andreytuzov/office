package io.office.data

import androidx.lifecycle.LiveData
import io.office.domain.model.Speciality
import io.office.domain.model.SpecialityWithWorkers
import io.office.domain.model.WorkerWithSpecialities

interface LocalWorkersDataSource {
    fun getSpecialities(): LiveData<List<Speciality>>
    fun getSpeciality(specialityId: Long): LiveData<SpecialityWithWorkers>
    fun getWorker(workerId: Long): LiveData<WorkerWithSpecialities>
    suspend fun saveWorkers(workers: List<WorkerWithSpecialities>)
}