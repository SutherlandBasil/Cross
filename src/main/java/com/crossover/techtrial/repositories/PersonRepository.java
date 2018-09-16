/**
 * 
 */
package com.crossover.techtrial.repositories;

import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.crossover.techtrial.model.Person;

/**
 * Person repository for basic operations on Person entity.
 * @author crossover
 */
@interface RestResource
{

	boolean exported();}

@RestResource(exported=false)
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
  Optional<Person> findById(Long id);

Iterable<Person> findAll();

Person save(Person p);

void deleteById(Long id);
}
