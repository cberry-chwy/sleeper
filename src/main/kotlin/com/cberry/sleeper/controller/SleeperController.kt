package com.cberry.sleeper.controller

import org.openapitools.client.apis.SleeperApi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sleeper")
class SleeperController(
    @Autowired private val client: SleeperApi
) {

    @RequestMapping(
        value = ["/user/{uid}"],
        produces = ["application/json"],
        method = [RequestMethod.GET]
    )
    fun getLandingPage(@PathVariable("uid") uid: String): User {
        return client.getUser(uid)
    }

}