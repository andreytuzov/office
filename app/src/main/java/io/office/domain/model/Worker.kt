package io.office.domain.model

data class Worker(
        val name: String,
        val lastName: String,
        val avatarUri: String?,
        val birthday: String?,
        val specialityIds: List<Int>
)