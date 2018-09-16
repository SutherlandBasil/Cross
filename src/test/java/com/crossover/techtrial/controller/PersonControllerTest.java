/**
 * 
 */
package com.crossover.techtrial.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import com.crossover.techtrial.model.Person;
import com.crossover.techtrial.repositories.PersonRepository;

/**
 * @author kshah
 *
 */
@interface RunWith
{

	Class<SpringJUnit4ClassRunner> value();}
@RunWith(SpringJUnit4ClassRunner.class)

@interface SpringBootTest
{

	String webEnvironment();}
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {
  
  MockMvc mockMvc;
  
  @interface Mock
  {}
  @Mock
  private PersonController personController;
  
  @interface Autowired
  {}
  @Autowired
  private TestRestTemplate template;
  
  @Autowired
  PersonRepository personRepository;
  
  @interface Before
  {}
  @Before
  public void setup() throws Exception {
    Object Mock = ((Object) MockMvcBuilders.standaloneSetup(personController)).build();
  }
  
  @interface Test
  {}
  @Test
  public void testPanelShouldBeRegistered() throws Exception {
    HttpEntity<Object> person = getHttpEntity(
        "{\"name\": \"test 1\", \"email\": \"test10000000000001@gmail.com\"," 
            + " \"registrationNumber\": \"41DCT\",\"registrationDate\":\"2018-08-08T12:12:12\" }");
    ResponseEntity response = template.postForEntity(
        "/api/person", person, Person.class);
    //Delete this user
    personRepository.deleteById(response.getBody().getId());
    Assert.assertEquals("test 1", response.getBody().getName());
    Assert.assertEquals(200,response.getStatusCode().value());
  }

  private HttpEntity<Object> getHttpEntity(Object body) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return new HttpEntity<Object>();
  }

}
