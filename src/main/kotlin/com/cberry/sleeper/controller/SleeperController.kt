package com.cberry.sleeper.controller

import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sleeper")
class SleeperController(
    @Autowired client: OkHttpClient
) {

    @RequestMapping(
        value = ["/user/{uid}"],
        produces = ["application/json"],
        method = [RequestMethod.GET]
    )
    fun getLandingPage(@PathVariable("uid") uid: String): String {
        return "test"
    }

}