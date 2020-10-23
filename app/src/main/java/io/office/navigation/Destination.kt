package io.office.navigation

sealed class Destination {
    object Specialities : Destination()
    data class Speciality(val specialityId: Long) : Destination()
    data class Worker(val workerId: Long) : Destination()
}