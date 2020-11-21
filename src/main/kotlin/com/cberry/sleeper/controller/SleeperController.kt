package com.cberry.sleeper.controller

import com.cberry.sleeper.generated.client.apis.LeagueApi
import com.cberry.sleeper.generated.client.apis.UserApi
import com.cberry.sleeper.generated.client.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sleeper")
class SleeperController(
    @Autowired private val userApi: UserApi,
    @Autowired private val leagueApi: LeagueApi
) {

    @RequestMapping(
        value = ["/user/{uid}"],
        produces = ["application/json"],
        method = [RequestMethod.GET]
    )
    fun getLandingPage(@PathVariable("uid") uid: String): User {
        return userApi.getUser(uid)
    }

}