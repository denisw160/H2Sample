package me.wirries.sample.h2sample;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * This class is the base class for all tests.
 */
@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
@ActiveProfiles({"test", "noJobs"})
public abstract class AbstractApplicationTests {

}
