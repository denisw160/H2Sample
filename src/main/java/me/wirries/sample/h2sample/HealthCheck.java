package me.wirries.sample.h2sample;

import me.wirries.sample.h2sample.repository.SampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * This is a simple health check for testing the database access.
 *
 * @author denisw
 * @version 1.0
 * @since 17.03.2019
 */
@Component
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class HealthCheck implements HealthIndicator {

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthCheck.class);

    @Autowired
    private SampleRepository repository;

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    /**
     * Perform health check and query the database.
     *
     * @return 0 if everything is ok
     */
    private int check() {
        try {
            long count = repository.count();
            LOGGER.debug("Return {} entities from database", count);
            return 0;
        } catch (Exception e) {
            LOGGER.error("Error while accessing database", e);
            return -1;
        }
    }

}
