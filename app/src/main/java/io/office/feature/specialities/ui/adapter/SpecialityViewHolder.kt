package io.office.feature.specialities.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.office.R
import io.office.domain.model.Speciality

class SpecialityViewHolder(
    parent: ViewGroup,
    private val itemClickListener: (Speciality) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.item_speciality,
        parent,
        false
    )
) {

    private val textSpeciality: TextView = itemView.findViewById(R.id.textSpeciality)

    init {
        itemView.setOnClickListener {
            (it.tag as? Speciality)
                ?.let(itemClickListener)
        }
    }

    fun bind(speciality: Speciality) {
        itemView.tag = speciality
        textSpeciality.text = speciality.name
    }
}