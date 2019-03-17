package me.wirries.sample.h2sample.controller;

import me.wirries.sample.h2sample.job.GenerateDataJob;
import me.wirries.sample.h2sample.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * This controller provides rest methods for accessing information of the entity sample.
 *
 * @author denisw
 * @version 1.0
 * @since 17.03.2019
 */
@RestController
public class SampleController {

    private GenerateDataJob job;
    private SampleRepository repository;

    @Autowired
    public SampleController(GenerateDataJob job, SampleRepository repository) {
        this.job = job;
        this.repository = repository;
    }

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public SampleInfoResponse getInfo() {
        SampleInfoResponse response = new SampleInfoResponse();
        response.setLastCount(job.getLastRunCount());
        response.setLastDuration(job.getLastRunDuration());
        response.setDbCount(repository.count());
        response.setFileSize(getFileSize());
        return response;
    }

    /**
     * Get the file size of the database.
     *
     * @return database size
     */
    private long getFileSize() {
        try {
            File f = new File("./h2sample.mv.db");
            return f.length();
        } catch (Exception e) {
            return -1;
        }
    }


}
