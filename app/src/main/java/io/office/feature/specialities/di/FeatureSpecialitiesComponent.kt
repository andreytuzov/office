package io.office.feature.specialities.di

import dagger.Component
import io.office.di.scope.PerFeature
import io.office.domain.WorkersRepository
import io.office.feature.specialities.ui.SpecialitiesFragment
import io.office.navigation.Router

@Component(
    modules = [FeatureSpecialitiesModule::class],
    dependencies = [FeatureSpecialitiesDependencies::class]
)
@PerFeature
interface FeatureSpecialitiesComponent {
    fun inject(fragment: SpecialitiesFragment)
}

interface FeatureSpecialitiesDependencies {
    fun router(): Router
    fun repository(): WorkersRepository
}