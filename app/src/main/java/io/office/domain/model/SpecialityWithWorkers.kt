package io.office.domain.model

data class SpecialityWithWorkers(
    val speciality: Speciality,
    val workers: List<Worker>
)