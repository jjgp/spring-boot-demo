package com.example.demo.hello

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RouterFunction

import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration(proxyBeanMethods = false)
class GreetingRouter {
    @Bean
    fun route(greetingHandler: GreetingHandler): RouterFunction<ServerResponse> {
        return RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello)
    }
}