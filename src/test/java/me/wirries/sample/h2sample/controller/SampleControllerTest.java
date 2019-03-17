package me.wirries.sample.h2sample.controller;

import me.wirries.sample.h2sample.AbstractApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Testcase for {@link SampleController}.
 */
public class SampleControllerTest extends AbstractApplicationTests {

    @Autowired
    private SampleController controller;

    @Test
    public void getInfo() {
        SampleInfoResponse info = controller.getInfo();
        assertNotNull(info);
        assertTrue(info.getDbCount() >= 0);
        assertTrue(info.getLastCount() >= 0);
        assertTrue(info.getLastDuration() >= 0);
        assertTrue(info.getFileSize() >= 0);
    }

}
