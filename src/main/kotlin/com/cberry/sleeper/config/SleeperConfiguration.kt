package com.cberry.sleeper.config

import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SleeperConfiguration {

    @Bean
    fun getHttpClient(): OkHttpClient {
        return OkHttpClient()
    }
}