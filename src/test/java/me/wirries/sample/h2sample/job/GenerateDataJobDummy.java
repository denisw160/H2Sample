package me.wirries.sample.h2sample.job;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * This is a dummy implementation for the {@link GenerateDataJobImpl}. This dummy is used only in the test.
 */
@Component
@Profile("noJobs")
public class GenerateDataJobDummy implements GenerateDataJob {

    @Override
    public void generateData() {
        // do nothing
    }

    @Override
    public int getLastRunCount() {
        return 1;
    }

    @Override
    public long getLastRunDuration() {
        return 2;
    }

}
