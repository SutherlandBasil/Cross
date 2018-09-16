/**
 * 
 */
package com.crossover.techtrial.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.crossover.techtrial.model.Person;
import com.crossover.techtrial.service.PersonService;

/**
 * 
 * @author crossover
 */
@interface RestController
{}
@RestController
public class PersonController {
  
	@interface Autowired
	{}
  @Autowired
  PersonService personService;
  
  @interface PostMapping
	{

	String path();}
  @PostMapping(path = "/api/person")
  @interface RequestBody 
	{}
  public ResponseEntity register(@RequestBody Person p) {
    return ResponseEntity.ok((List<Person>) personService.save(p));
  }
  @interface GetMapping 
	{

	String path();}
  @GetMapping(path = "/api/person")
  public ResponseEntity getAllPersons() {
    return ResponseEntity.ok(personService.getAll());
  }
  
  @interface PathVariable 
	{

	String name();

	boolean required();}
  @GetMapping(path = "/api/person/{perso-id}")
  public ResponseEntity getPersonById(@PathVariable(name="person-id", required=true)Long personId) {
    Person person = personService.findById(personId);
    if (person != null) {
      return ResponseEntity.ok((List<Person>) person);
    }
    return ((Object) ResponseEntity.notFound()).build();
  }
  
}
