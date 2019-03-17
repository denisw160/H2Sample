package me.wirries.sample.h2sample.controller;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class is the response for status of sample.
 *
 * @author denisw
 * @version 1.0
 * @since 17.03.2019
 */
@SuppressWarnings("WeakerAccess")
public class SampleInfoResponse {

    private long lastDuration;
    private int lastCount;

    private long fileSize;

    private long dbCount;


    public long getLastDuration() {
        return lastDuration;
    }

    public void setLastDuration(long lastDuration) {
        this.lastDuration = lastDuration;
    }

    public int getLastCount() {
        return lastCount;
    }

    public void setLastCount(int lastCount) {
        this.lastCount = lastCount;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public long getDbCount() {
        return dbCount;
    }

    public void setDbCount(long dbCount) {
        this.dbCount = dbCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("lastDuration", lastDuration)
                .append("lastCount", lastCount)
                .append("fileSize", fileSize)
                .append("dbCount", dbCount)
                .toString();
    }

}
