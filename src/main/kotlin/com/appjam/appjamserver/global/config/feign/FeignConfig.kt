package com.appjam.appjamserver.global.config.feign

import com.appjam.appjamserver.global.config.feign.error.FeignClientErrorDecoder
import feign.Logger
import feign.codec.ErrorDecoder
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.cloud.commons.httpclient.HttpClientConfiguration
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@ImportAutoConfiguration(classes = [FeignAutoConfiguration::class, HttpClientConfiguration::class])
@EnableFeignClients(basePackages = ["com.appjam.appjamserver"])
@Configuration
@Import(FeignClientErrorDecoder::class)
class FeignConfig {

    @Bean
    fun feignLoggerLevel(): Logger.Level = Logger.Level.FULL

    @Bean
    @ConditionalOnMissingBean(value = [ErrorDecoder::class]) //Bean 오버라이딩시 충돌 해결
    fun commonFeignErrorDecoder(): FeignClientErrorDecoder = FeignClientErrorDecoder()
}
