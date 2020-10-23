package io.office.domain.model

data class WorkerWithSpecialities(
    val worker: Worker,
    val specialities: List<Speciality>
)