package io.office.feature.speciality.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import io.office.domain.model.Worker

class WorkerAdapter(
    private val itemClickListener: (Worker) -> Unit
) : ListAdapter<Worker, WorkerViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerViewHolder {
        return WorkerViewHolder.create(parent, itemClickListener)
    }

    override fun onBindViewHolder(holder: WorkerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Worker>() {

            override fun areItemsTheSame(oldItem: Worker, newItem: Worker): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Worker, newItem: Worker): Boolean {
                return oldItem == newItem
            }
        }
    }
}

