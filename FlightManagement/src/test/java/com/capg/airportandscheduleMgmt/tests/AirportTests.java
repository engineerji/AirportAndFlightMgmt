package com.capg.airportandscheduleMgmt.tests;


import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capg.flightmanagement.dao.IAirportDao;
import com.capg.flightmanagement.exceptions.AirportNotFoundException;
import com.capg.flightmanagement.models.Airport;
import com.capg.flightmanagement.service.AirportServiceImpl;
import com.capg.flightmanagement.service.IAirportService;

@SpringBootTest
class AirportTests {
	
	@Autowired
	IAirportService airportService;

	@Autowired
	IAirportDao airportDao;
	
	@Test
	public void fetchAirport_1() {
		Airport airport = new Airport("IGI123","IGI","New Delhi");
		Airport result = airportService.fetchAirportById("IGI123");
		Assertions.assertEquals(result, airport);
	}
	
	@Test
	public void fetchAirport_2() {
		Executable executable = () -> airportService.fetchAirportById("S46");
		Assertions.assertThrows(AirportNotFoundException.class, executable);
	}
	
	@Test
	public void deleteAirport_1() {
		
	}
	
	@Test public void deleteAirport_2() {
		Executable executable = () -> airportService.removeAirport("S46");
		Assertions.assertThrows(AirportNotFoundException.class, executable);
	}
}
