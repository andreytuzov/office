package io.office.data.remote.response

import com.squareup.moshi.Json

data class WorkersResponse(
    @field:Json(name = "response")
    val workers: List<WorkerResponse>
)