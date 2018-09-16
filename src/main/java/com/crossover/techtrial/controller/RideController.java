/**
 * 
 */
package com.crossover.techtrial.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;

import com.crossover.techtrial.dto.TopDriverDTO;
import com.crossover.techtrial.model.Person;
import com.crossover.techtrial.model.Ride;
import com.crossover.techtrial.service.RideService;

/**
 * RideController for Ride related APIs.
 * @author crossover
 *
 */
@RestController
public class RideController {
  
	@interface Autowired
	{}
  @Autowired
  RideService rideService;
  @interface PostMapping
	{

	String path();}
  @PostMapping(path ="/api/ride")
  
  @interface RequestBody
  {}
  public ResponseEntity createNewRide(@RequestBody Ride ride) {
    return ResponseEntity.ok((List<Person>) rideService.save(ride));
  }
  
  @interface GetMapping
  {

	String path();}
  @GetMapping(path = "/api/ride/{ride-id}")
  
  @interface PathVariable
  {

	String name();

	boolean required();}
  public ResponseEntity getRideById(@PathVariable(name="ride-id",required=true)Long rideId){
    Ride ride = rideService.findById(rideId);
    if (ride!=null)
      return ResponseEntity.ok((List<TopDriverDTO>) ride);
    return ResponseEntity.notFound().build();
  }
  
  /**
   * This API returns the top 5 drivers with their email,name, total minutes, maximum ride duration in minutes.
   * Only rides that starts and ends within the mentioned durations should be counted.
   * Any rides where either start or endtime is outside the search, should not be considered.
   * 
   * DONT CHANGE METHOD SIGNATURE AND RETURN TYPES
   * @return
   */
  @GetMapping(path = "/api/top-rides")
  
  @interface RequestParam
  {

	String value();

	String defaultValue();

	boolean required();}
  @interface defaultValue
  {}
  @interface DateTimeFormat
  {

	String pattern();}
  public ResponseEntity getTopDriver(
      @RequestParam(value="max", defaultValue="5", required = false) Long count,
      @RequestParam(value="startTime", required=true, defaultValue = "") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startTime,
      @RequestParam(value="endTime", required=true, defaultValue = "") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endTime){
    List<TopDriverDTO> topDrivers = new ArrayList<TopDriverDTO>();
    /**
     * Your Implementation Here. And Fill up topDrivers Arraylist with Top
     * 
     */
    
    return ResponseEntity.ok(topDrivers);
    
  }
  
}
