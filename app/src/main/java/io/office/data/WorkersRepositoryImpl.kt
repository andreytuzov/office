package io.office.data

import androidx.lifecycle.LiveData
import io.office.data.model.RemoteWorkersResult
import io.office.domain.WorkersRepository
import io.office.domain.model.RefreshResult
import io.office.domain.model.Speciality
import io.office.domain.model.SpecialityWithWorkers
import io.office.domain.model.WorkerWithSpecialities
import javax.inject.Inject

class WorkersRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteWorkersDataSource,
    private val localDataSource: LocalWorkersDataSource
) : WorkersRepository {

    override suspend fun refreshData(): RefreshResult {
        return when (val result = remoteDataSource.getWorkers()) {
            is RemoteWorkersResult.NetworkConnectionError,
            is RemoteWorkersResult.NotFoundException -> RefreshResult.NetworkConnectionError
            is RemoteWorkersResult.Success -> {
                localDataSource.saveWorkers(result.workers)
                RefreshResult.Success
            }
        }
    }

    override fun getSpeciality(): LiveData<List<Speciality>> {
        return localDataSource.getSpecialities()
    }

    override fun getSpeciality(id: Long): LiveData<SpecialityWithWorkers> {
        return localDataSource.getSpeciality(id)
    }

    override fun getWorker(id: Long): LiveData<WorkerWithSpecialities> {
        return localDataSource.getWorker(id)
    }
}