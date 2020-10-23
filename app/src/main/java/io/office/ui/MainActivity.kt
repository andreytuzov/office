package io.office.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.office.App
import io.office.R
import io.office.navigation.Destination
import io.office.navigation.Router
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDagger()
        router.setNavigator(ActivityNavigator(this))
        if (savedInstanceState == null) {
            router.goto(Destination.Specialities)
        }
    }

    private fun setupDagger() {
        App.appComponent.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        router.setNavigator(null)
    }
}






