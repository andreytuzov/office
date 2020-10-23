package io.office.feature.speciality.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.office.R
import io.office.databinding.ItemWorkerBinding
import io.office.domain.model.Worker

class WorkerViewHolder private constructor(
    private val binding: ItemWorkerBinding,
    private val itemClickListener: (Worker) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.listener = itemClickListener
    }

    fun bind(worker: Worker) {
        binding.worker = worker
        binding.executePendingBindings()
    }

    companion object {

        fun create(
            parent: ViewGroup,
            itemClickListener: (Worker) -> Unit
        ) = WorkerViewHolder(
            binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_worker,
                parent,
                false
            ),
            itemClickListener = itemClickListener
        )
    }
}