package io.office.speciality

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import io.office.domain.model.Worker

class WorkersAdapter() : ListAdapter<Worker, WorkersViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkersViewHolder {
        return WorkersViewHolder(parent)
    }

    override fun onBindViewHolder(holder: WorkersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Worker>() {

            override fun areItemsTheSame(oldItem: Worker, newItem: Worker): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Worker, newItem: Worker): Boolean {
                return oldItem == newItem
            }
        }
    }
}