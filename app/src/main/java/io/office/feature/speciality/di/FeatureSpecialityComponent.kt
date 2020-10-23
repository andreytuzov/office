package io.office.feature.speciality.di

import dagger.Component
import io.office.di.scope.PerFeature
import io.office.domain.WorkersRepository
import io.office.feature.speciality.ui.SpecialityFragment
import io.office.navigation.Router


@Component(
    modules = [FeatureSpecialityModule::class],
    dependencies = [FeatureSpecialityDependencies::class]
)
@PerFeature
interface FeatureSpecialityComponent {
    fun inject(fragment: SpecialityFragment)
}

interface FeatureSpecialityDependencies {
    fun router(): Router
    fun repository(): WorkersRepository
}