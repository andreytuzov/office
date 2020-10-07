package io.office.api.response

import com.squareup.moshi.Json
import io.office.api.response.SpecialityResponse

data class WorkerResponse(
        @field:Json(name = "f_name")
        val name: String,
        @field:Json(name = "l_name")
        val lastName: String,
        @field:Json(name = "birthday")
        val birthday: String?,
        @field:Json(name = "avatr_url")
        val avatarUrl: String?,
        @field:Json(name = "specialty")
        val specialities: List<SpecialityResponse>
)