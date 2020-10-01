package com.capg.flightmgmt;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.flightmgmt.entities.Airport;
import com.capg.flightmgmt.exceptions.AirportNotFoundException;
import com.capg.flightmgmt.service.IAirportService;

@SpringBootTest
class AirportTests {

	@Autowired
	private IAirportService airportService;
	
	private Airport airport;

	@BeforeAll
	public void setUp()
	{
		this.airport = new Airport("IG123","IGI","Delhi");
		this.airportService.addAirport(airport);
	}
	@Test
	public void fetchAirport_1() {
		Airport result = airportService.fetchAirportById("IG123");
		Assertions.assertEquals(result, this.airport);
	}
	
	@Test
	public void fetchAirport_2() {
		Executable executable = () -> airportService.fetchAirportById("S46");
		Assertions.assertThrows(AirportNotFoundException.class, executable);
	}
	
	@Test
	public void deleteAirport_1() {
		Airport airport = new Airport("SHE485","IGI","Delhi");
		airportService.addAirport(airport);
		String executable = airportService.removeAirport("SHE485");
		String expected="Deleted";
		Assertions.assertEquals(expected, executable);
	}
	
	@Test public void deleteAirport_2() {
		Executable executable = () -> airportService.removeAirport("S46");
		Assertions.assertThrows(AirportNotFoundException.class, executable);
	}
	
	@Test
	public void updateAirport_1() {
		Airport airport = new Airport("IGI123","IGI","Delhi");
		airportService.addAirport(airport);
		String actual = airportService.updateAirport(airport);
		String expected="Updated";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test public void updateAirport_2() {
		Airport airport = new Airport("I123","IGI","Delhi");
		Executable executable = () -> airportService.updateAirport(airport);
		Assertions.assertThrows(AirportNotFoundException.class, executable);
	}
}
