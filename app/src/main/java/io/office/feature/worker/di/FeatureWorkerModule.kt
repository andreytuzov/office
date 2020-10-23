package io.office.feature.worker.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.office.di.ViewModelKey
import io.office.feature.worker.domain.interactor.GetWorkerUseCase
import io.office.feature.worker.presentation.WorkerViewModel
import io.office.feature.worker.presentation.WorkerViewModelImpl
import io.office.ui.base.ViewModelFactory

@Module
interface FeatureWorkerModule {

    @Binds
    fun bindGetWorkerUseCase(impl: GetWorkerUseCase.Impl): GetWorkerUseCase

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @ViewModelKey(WorkerViewModel::class)
    @Binds
    fun bindWorkerViewModel(impl: WorkerViewModelImpl): ViewModel
}