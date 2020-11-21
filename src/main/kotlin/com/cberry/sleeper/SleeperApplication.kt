package com.cberry.sleeper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SleeperApplication

fun main(args: Array<String>) {
    runApplication<SleeperApplication>(*args)
}
