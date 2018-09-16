/**
 * 
 */
package com.crossover.techtrial.repositories;

import com.crossover.techtrial.model.Ride;

import java.util.Optional;

/**
 * @author crossover
 *
 */
@RestResource(exported = false)
public interface RideRepository extends CrudRepository<Ride, Long> {

	Ride save(Ride ride);

	Optional<Ride> findById(Long rideId);

}
