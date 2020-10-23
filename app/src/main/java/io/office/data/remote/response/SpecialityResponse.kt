package io.office.data.remote.response

import com.squareup.moshi.Json

data class SpecialityResponse(
        @field:Json(name = "specialty_id")
        val id: Int,
        @field:Json(name = "name")
        val name: String
)