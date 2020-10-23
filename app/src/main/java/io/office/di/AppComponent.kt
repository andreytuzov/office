package io.office.di

import dagger.BindsInstance
import dagger.Component
import io.office.App
import io.office.di.scope.AppScope
import io.office.feature.specialities.di.FeatureSpecialitiesDependencies
import io.office.feature.speciality.di.FeatureSpecialityDependencies
import io.office.feature.worker.di.FeatureWorkerDependencies
import io.office.ui.MainActivity
import io.office.feature.worker.ui.WorkerFragment

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent : FeatureSpecialitiesDependencies, FeatureSpecialityDependencies,
    FeatureWorkerDependencies {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(application: App): Builder
    }

    fun inject(activity: MainActivity)
}