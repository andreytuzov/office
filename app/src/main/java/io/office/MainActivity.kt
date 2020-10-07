package io.office

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.office.speciality.SpecialityFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SpecialityFragment.newInstance())
                    .commitNow()
        }
    }
}