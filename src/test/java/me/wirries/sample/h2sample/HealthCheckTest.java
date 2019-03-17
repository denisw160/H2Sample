package me.wirries.sample.h2sample;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

import static org.junit.Assert.assertEquals;

/**
 * Testcase for {@link HealthCheck}.
 */
public class HealthCheckTest extends AbstractApplicationTests {

    @Autowired
    private HealthCheck healthCheck;

    @Test
    public void health() {
        Health health = healthCheck.health();
        assertEquals(Status.UP, health.getStatus());
    }
}
