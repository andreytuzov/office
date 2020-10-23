package io.office.feature.speciality.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.office.App
import io.office.R
import io.office.domain.model.SpecialityWithWorkers
import io.office.extensions.subscribe
import io.office.feature.speciality.di.DaggerFeatureSpecialityComponent
import io.office.feature.speciality.presentation.SpecialityViewModel
import io.office.feature.speciality.ui.adapter.WorkerAdapter
import kotlinx.android.synthetic.main.fragment_speciality.*
import javax.inject.Inject

class SpecialityFragment : Fragment() {

    private var specialityId: Long = 0L

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SpecialityViewModel
    private lateinit var adapter: WorkerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        specialityId = arguments!!.getLong(SPECIALITY_ID)
        DaggerFeatureSpecialityComponent.builder()
            .featureSpecialityDependencies(App.appComponent)
            .build()
            .inject(this)
        viewModel = ViewModelProvider(viewModelStore, viewModelFactory)
            .get(SpecialityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_speciality, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = WorkerAdapter(viewModel::onWorkerClicked)
        recyclerView.adapter = adapter
        subscribe(viewModel.loadSpeciality(specialityId), ::bind)
    }

    private fun bind(data: SpecialityWithWorkers) {
        textSpeciality.text = data.speciality.name
        adapter.submitList(data.workers)
    }

    companion object {

        private const val SPECIALITY_ID = "specialityId"

        fun newInstance(specialityId: Long) = SpecialityFragment().apply {
            arguments = Bundle().apply { putLong(SPECIALITY_ID, specialityId) }
        }
    }
}