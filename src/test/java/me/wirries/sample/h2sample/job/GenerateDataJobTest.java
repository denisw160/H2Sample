package me.wirries.sample.h2sample.job;

import me.wirries.sample.h2sample.AbstractApplicationTests;
import me.wirries.sample.h2sample.repository.SampleRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Testcase for {@link GenerateDataJobImpl}.
 */
public class GenerateDataJobTest extends AbstractApplicationTests {

    @Autowired
    private SampleRepository repository;

    private GenerateDataJob job;

    @Before
    public void setUp() {
        repository.deleteAll();
        job = new GenerateDataJobImpl(repository);
    }

    @Test
    public void generateData() {
        int lastRunCount = job.getLastRunCount();
        assertEquals(0, lastRunCount);

        long lastRunDuration = job.getLastRunDuration();
        assertEquals(0, lastRunDuration);

        job.generateData();

        lastRunCount = job.getLastRunCount();
        assertTrue(lastRunCount > 0);

        lastRunDuration = job.getLastRunDuration();
        assertTrue(lastRunDuration > 0);

    }

}
