package me.wirries.sample.h2sample.job;

/**
 * Job for generating data.
 *
 * @author denisw
 * @version 1.0
 * @since 17.03.2019
 */
public interface GenerateDataJob {

    /**
     * Generate data in the database and save the execution time.
     */
    void generateData();

    /**
     * Return the count of the last stored entities.
     *
     * @return count of the entities
     */
    int getLastRunCount();

    /**
     * Return the duration of the last execution.
     *
     * @return duration
     */
    long getLastRunDuration();

}
