package me.wirries.sample.h2sample.repository;

import me.wirries.sample.h2sample.AbstractApplicationTests;
import me.wirries.sample.h2sample.model.Sample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Testcase for {@link SampleRepository}.
 *
 * @author denisw
 * @version 1.0
 * @since 17.03.2019
 */
public class SampleRepositoryTest extends AbstractApplicationTests {

    @Autowired
    private SampleRepository repository;

    @Before
    public void setUp() {
        repository.deleteAll();
        assertEquals(0, repository.count());

        for (int i = 0; i < 100; i++) {
            Sample s = new Sample();
            s.setValue1(String.valueOf(i));
            s.setValue2(i);
            repository.save(s);
        }
    }

    @Test
    public void load() {
        Iterable<Sample> all = repository.findAll();
        int i = 0;
        for (Sample ignored : all) {
            i++;
        }
        assertEquals(100, i);
    }
}
