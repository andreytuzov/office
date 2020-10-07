package io.office.speciality

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.office.R
import io.office.extensions.subscribe
import kotlinx.android.synthetic.main.fragment_speciality.*

class SpecialityFragment : Fragment() {

    private lateinit var specialityViewModel: SpecialityViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_speciality, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        specialityViewModel = ViewModelProvider(viewModelStore, SpecialityViewModelFactory(requireContext()))
                .get(SpecialityViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = WorkersAdapter()
        recyclerView.adapter = adapter
        subscribe(specialityViewModel.workers, adapter::submitList)
    }

    companion object {
        fun newInstance() = SpecialityFragment()
    }
}