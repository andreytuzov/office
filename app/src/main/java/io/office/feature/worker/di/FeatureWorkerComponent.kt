package io.office.feature.worker.di

import dagger.Component
import io.office.di.scope.PerFeature
import io.office.domain.WorkersRepository
import io.office.feature.worker.ui.WorkerFragment
import io.office.navigation.Router

@Component(
    modules = [FeatureWorkerModule::class],
    dependencies = [FeatureWorkerDependencies::class]
)
@PerFeature
interface FeatureWorkerComponent {
    fun inject(fragment: WorkerFragment)
}

interface FeatureWorkerDependencies {
    fun router(): Router
    fun repository(): WorkersRepository
}