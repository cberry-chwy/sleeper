package com.cberry.sleeper.model

import com.cberry.sleeper.constants.SLEEPER_CDN
import com.cberry.sleeper.generated.client.models.League
import com.cberry.sleeper.generated.client.models.User

data class Profile(
    val userId: String = "",
    val userName: String = "",
    val displayName: String = "",
    val avatarUrl: String = ""
)

fun User.toProfile(leauge: League? = null): Profile =
    Profile(
        userId = this.userId,
        userName = this.username,
        displayName = this.displayName,
        avatarUrl = "$SLEEPER_CDN/avatars/${this.avatar}"
    )
