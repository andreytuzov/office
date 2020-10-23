package io.office.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import io.office.data.LocalWorkersDataSource
import io.office.data.local.dao.WorkersDao
import io.office.data.local.mapper.LocalWorkersMapper
import io.office.domain.model.Speciality
import io.office.domain.model.SpecialityWithWorkers
import io.office.domain.model.WorkerWithSpecialities
import javax.inject.Inject

class LocalWorkersDataSourceImpl @Inject constructor(
    private val dao: WorkersDao,
    private val mapper: LocalWorkersMapper
) : LocalWorkersDataSource {

    override fun getSpecialities(): LiveData<List<Speciality>> {
        return Transformations.map(dao.getSpecialities()) {
            it.map(mapper::map)
        }
    }

    override fun getSpeciality(specialityId: Long): LiveData<SpecialityWithWorkers> {
        return Transformations.map(dao.getSpeciality(specialityId)) {
            mapper.map(it)
        }
    }

    override fun getWorker(workerId: Long): LiveData<WorkerWithSpecialities> {
        return Transformations.map(dao.getWorker(workerId)) {
            mapper.map(it)
        }
    }

    override suspend fun saveWorkers(workers: List<WorkerWithSpecialities>) {
        dao.saveWorkers(workers.map(mapper::map))
    }
}