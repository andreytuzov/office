package io.office.feature.specialities.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import io.office.domain.model.Speciality

class SpecialitiesAdapter(
    private val itemClickListener: (Speciality) -> Unit
) : ListAdapter<Speciality, SpecialityViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialityViewHolder {
        return SpecialityViewHolder(parent, itemClickListener)
    }

    override fun onBindViewHolder(holder: SpecialityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Speciality>() {
            override fun areItemsTheSame(oldItem: Speciality, newItem: Speciality): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Speciality, newItem: Speciality): Boolean {
                return oldItem == newItem
            }
        }
    }
}