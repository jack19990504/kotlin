package com.kotlin.jpa.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EntityScan("com.kotlin.jpa.entity")
@EnableJpaRepositories("com.kotlin.jpa.repository")
@Configuration
class JPAConfig {
}
