package io.office.speciality

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.office.domain.usecase.GetWorkersUseCase
import io.office.api.OfficeApi
import io.office.api.ApiWorkersDataSource
import io.office.data.WorkersDataSource
import io.office.data.WorkersRepositoryImpl
import io.office.data.mappers.WorkersLocalMapper
import io.office.data.mappers.WorkersRepositoryMapper
import io.office.db.LocalWorkersDataSource
import io.office.db.WorkerDatabase
import io.office.db.WorkersDao
import io.office.domain.WorkersRepository

class SpecialityViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val applicationContext = context.applicationContext

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val remoteApi = OfficeApi.officeApiService
        val onlineDataSource = ApiWorkersDataSource(remoteApi, WorkersRepositoryMapper.Impl())
        val database = WorkerDatabase.getInstance(applicationContext)
        val localDataSource = LocalWorkersDataSource(database.workersDao(), WorkersLocalMapper.Impl())
        val repository = WorkersRepositoryImpl(onlineDataSource, localDataSource)
        val getWorkersUseCase = GetWorkersUseCase.Impl(repository)
        return SpecialityViewModelImpl(getWorkersUseCase) as T
    }
}