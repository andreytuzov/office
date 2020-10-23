package io.office.feature.specialities.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.office.App
import io.office.R
import io.office.extensions.subscribe
import io.office.feature.specialities.di.DaggerFeatureSpecialitiesComponent
import io.office.feature.specialities.ui.adapter.SpecialitiesAdapter
import io.office.feature.specialities.presentation.SpecialitiesViewModel
import kotlinx.android.synthetic.main.fragment_specialities.*
import javax.inject.Inject

class SpecialitiesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SpecialitiesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFeatureSpecialitiesComponent.builder()
            .featureSpecialitiesDependencies(App.appComponent)
            .build()
            .inject(this)
        viewModel = ViewModelProvider(viewModelStore, viewModelFactory)
            .get(SpecialitiesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_specialities, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = SpecialitiesAdapter(viewModel::onSpecialityClicked)
        recyclerView.adapter = adapter
        subscribe(viewModel.specialities, adapter::submitList)
    }

    companion object {
        fun newInstance() = SpecialitiesFragment()
    }
}