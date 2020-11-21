package com.cberry.sleeper.controller

import com.cberry.sleeper.constants.SPORT_NFL
import com.cberry.sleeper.generated.client.apis.LeagueApi
import com.cberry.sleeper.generated.client.apis.UserApi
import com.cberry.sleeper.generated.client.models.League
import com.cberry.sleeper.model.Profile
import com.cberry.sleeper.model.toProfile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sleeper")
class SleeperController(
    @Autowired private val userApi: UserApi,
    @Autowired private val leagueApi: LeagueApi
) {

    @RequestMapping(
        value = ["/profile/{uid}"],
        produces = ["application/json"],
        method = [RequestMethod.GET]
    )
    fun getProfile(
        @PathVariable("uid") uid: String,
        @RequestParam("year", required = false) year: String? = null
    ): Profile {
        val user = userApi.getUser(uid)
        val leagues = userApi.getLeagues(user.userId, SPORT_NFL, year.orEmpty())
        return user.toProfile(leagues.firstOrNull())
    }

    @RequestMapping(
        value = ["/matchups/{leagueId}"],
        produces = ["application/json"],
        method = [RequestMethod.GET]
    )
    fun getMatchups(@PathVariable("leagueId") leagueId: String): League {
        val league = leagueApi.getLeague(leagueId)
        return league
    }

}
