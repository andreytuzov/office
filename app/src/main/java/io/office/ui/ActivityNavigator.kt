package io.office.ui

import androidx.appcompat.app.AppCompatActivity
import io.office.R
import io.office.navigation.Destination
import io.office.navigation.Navigator
import io.office.feature.specialities.ui.SpecialitiesFragment
import io.office.feature.speciality.ui.SpecialityFragment
import io.office.feature.worker.ui.WorkerFragment

class ActivityNavigator(private val activity: AppCompatActivity) : Navigator {

    override fun navigateTo(destination: Destination) {
        val fragment = when (destination) {
            is Destination.Specialities -> SpecialitiesFragment.newInstance()
            is Destination.Speciality -> SpecialityFragment.newInstance(destination.specialityId)
            is Destination.Worker -> WorkerFragment.newInstance(destination.workerId)
            else -> null
        } ?: return
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}