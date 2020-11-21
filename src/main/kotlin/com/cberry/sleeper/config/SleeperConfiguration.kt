package com.cberry.sleeper.config

import com.cberry.sleeper.generated.client.apis.LeagueApi
import com.cberry.sleeper.generated.client.apis.UserApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SleeperConfiguration {

    @Bean
    fun getUserApi(): UserApi {
        return UserApi()
    }

    @Bean
    fun getLeagueApi(): LeagueApi {
        return LeagueApi()
    }
}