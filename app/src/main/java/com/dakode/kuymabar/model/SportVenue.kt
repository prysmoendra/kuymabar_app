package com.dakode.kuymabar.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SportVenue(
    val name: String = "",
    val address: String = "",
    val sport_branch: String = "",
    val district: String = "",
    val village: String = "",
    val land_area: Long = 0
)
