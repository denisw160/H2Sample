package me.wirries.sample.h2sample.job;

import me.wirries.sample.h2sample.model.Sample;
import me.wirries.sample.h2sample.repository.SampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Date;
import java.util.Random;

/**
 * This job generates data.
 *
 * @author denisw
 * @version 1.0
 * @since 17.03.2019
 */
@Component
@Profile("!noJobs")
public class GenerateDataJobImpl implements GenerateDataJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateDataJobImpl.class);

    private int lastRunCount;
    private long lastRunDuration;

    private SampleRepository repository;

    @Autowired
    public GenerateDataJobImpl(SampleRepository repository) {
        this.repository = repository;
    }

    /**
     * Generate data in the database and save the execution time.
     */
    @Override
    @Scheduled(fixedDelay = 500)
    public void generateData() {
        StopWatch watch = new StopWatch();
        watch.start();

        lastRunCount = getRandomCount();
        for (int i = 0; i < lastRunCount; i++) {
            Sample s = new Sample();
            s.setValue1(String.valueOf(i));
            s.setValue2(i);
            s.setValue3(new Date());
            repository.save(s);
        }

        watch.stop();
        lastRunDuration = watch.getTotalTimeMillis();
        LOGGER.debug("Adding {} entities in {} ms", lastRunCount, lastRunDuration);
    }

    /**
     * Return a random value.
     *
     * @return random value
     */
    private int getRandomCount() {
        Random r = new Random();
        int low = 100;
        int high = 10000;
        return r.nextInt(high - low) + low;
    }

    /**
     * Return the count of the last stored entities.
     *
     * @return count of the entities
     */
    @Override
    public int getLastRunCount() {
        return lastRunCount;
    }

    /**
     * Return the duration of the last execution.
     *
     * @return duration
     */
    @Override
    public long getLastRunDuration() {
        return lastRunDuration;
    }

}
