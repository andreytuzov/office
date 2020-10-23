package io.office.feature.speciality.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.office.di.ViewModelKey
import io.office.feature.speciality.domain.interactor.GetSpecialityUseCase
import io.office.feature.speciality.presentation.SpecialityViewModel
import io.office.feature.speciality.presentation.SpecialityViewModelImpl
import io.office.ui.base.ViewModelFactory

@Module
interface FeatureSpecialityModule {

    @Binds
    fun bindGetSpecialityUseCase(impl: GetSpecialityUseCase.Impl): GetSpecialityUseCase

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @ViewModelKey(SpecialityViewModel::class)
    @Binds
    fun bindSpecialityViewModel(impl: SpecialityViewModelImpl): ViewModel
}