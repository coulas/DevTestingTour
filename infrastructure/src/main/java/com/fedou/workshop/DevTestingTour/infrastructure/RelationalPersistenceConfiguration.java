package com.fedou.workshop.DevTestingTour.infrastructure;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(considerNestedRepositories = true)
@EntityScan//("com.fedou.workshop.DevTestingTour.infrastructure")
@ComponentScan//("com.fedou.workshop.DevTestingTour.infrastructure")
//@PropertySource("example/h2.properties")
public class RelationalPersistenceConfiguration {
}
