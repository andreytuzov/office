package io.office.feature.specialities.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.office.di.ViewModelKey
import io.office.feature.specialities.domain.interactor.GetSpecialitiesUseCase
import io.office.feature.specialities.domain.interactor.RefreshDataUseCase
import io.office.feature.specialities.presentation.SpecialitiesViewModel
import io.office.feature.specialities.presentation.SpecialitiesViewModelImpl
import io.office.ui.base.ViewModelFactory

@Module
interface FeatureSpecialitiesModule {

    @Binds
    fun bindGetSpecialitiesUseCase(impl: GetSpecialitiesUseCase.Impl): GetSpecialitiesUseCase

    @Binds
    fun bindRefreshDataUseCase(impl: RefreshDataUseCase.Impl): RefreshDataUseCase

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @ViewModelKey(SpecialitiesViewModel::class)
    @Binds
    fun bindSpecialitiesViewModel(impl: SpecialitiesViewModelImpl): ViewModel
}