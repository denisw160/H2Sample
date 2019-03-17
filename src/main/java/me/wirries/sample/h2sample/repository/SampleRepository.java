package me.wirries.sample.h2sample.repository;

import me.wirries.sample.h2sample.model.Sample;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * This is the repository for the entity {@link Sample}.
 *
 * @author denisw
 * @version 1.0
 * @since 17.03.2019
 */
@Transactional
public interface SampleRepository extends CrudRepository<Sample, String> {

}
