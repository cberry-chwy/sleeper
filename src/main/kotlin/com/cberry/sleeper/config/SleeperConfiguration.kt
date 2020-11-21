package com.cberry.sleeper.config

import org.openapitools.client.apis.SleeperApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SleeperConfiguration {

    @Bean
    fun getHttpClient(): SleeperApi {
        return SleeperApi()
    }
}