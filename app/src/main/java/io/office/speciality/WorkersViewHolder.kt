package io.office.speciality

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.office.R
import io.office.domain.model.Worker

class WorkersViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
                R.layout.item_worker,
                parent,
                false
        )
) {

    private val textName: TextView = itemView.findViewById(R.id.textName)

    fun bind(worker: Worker) {
        textName.text = worker.name
    }
}