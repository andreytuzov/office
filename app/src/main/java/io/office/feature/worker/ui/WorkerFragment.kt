package io.office.feature.worker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import io.office.App
import io.office.R
import io.office.domain.model.Worker
import io.office.domain.model.WorkerWithSpecialities
import io.office.extensions.subscribe
import io.office.feature.specialities.ui.adapter.SpecialitiesAdapter
import io.office.feature.worker.di.DaggerFeatureWorkerComponent
import io.office.feature.worker.presentation.WorkerViewModel
import kotlinx.android.synthetic.main.fragment_worker.*
import javax.inject.Inject

class WorkerFragment : Fragment() {

    private var workerId: Long = 0L

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: WorkerViewModel

    private lateinit var adapter: SpecialitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        workerId = arguments!!.getLong(WORKER_ID)
        DaggerFeatureWorkerComponent.builder()
            .featureWorkerDependencies(App.appComponent)
            .build()
            .inject(this)
        viewModel = ViewModelProvider(viewModelStore, viewModelFactory)
            .get(WorkerViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_worker, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = SpecialitiesAdapter(viewModel::onSpecialityClicked)
        recyclerView.adapter = adapter
        subscribe(viewModel.getWorker(workerId), ::bind)
    }

    private fun bind(data: WorkerWithSpecialities) {
        bind(data.worker)
        adapter.submitList(data.specialities)
    }

    private fun bind(worker: Worker) {
        textName.text = worker.name
        textLastName.text = worker.lastName
        textBirthday.text = worker.birthdayText
        textAge.text = worker.age
        bindAvatar(worker.avatarUri)
    }

    private fun bindAvatar(avatarUri: String?) {
        Glide.with(imageAvatar)
            .load(avatarUri)
            .error(R.drawable.avatar_default)
            .into(imageAvatar)
    }

    companion object {

        private const val WORKER_ID = "workerId"

        fun newInstance(workerId: Long) = WorkerFragment().apply {
            arguments = Bundle().apply { putLong(WORKER_ID, workerId) }
        }
    }
}