package io.office.api.response

import com.squareup.moshi.Json
import io.office.api.response.WorkerResponse

data class WorkersResponse(
    @field:Json(name = "response")
    val workers: List<WorkerResponse>
)