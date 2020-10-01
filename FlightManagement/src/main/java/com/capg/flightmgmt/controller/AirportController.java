package com.capg.flightmgmt.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.flightmgmt.dto.AirportRequest;
import com.capg.flightmgmt.entities.Airport;
import com.capg.flightmgmt.service.IAirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {

	@Autowired
	private IAirportService airportService;
	
	/**
	 * adding a airport and return airportDetails
	 * @Param airportDto
	 * @return
	 */
	@PostMapping("/add")
	ResponseEntity<Airport> addingAirport(@RequestBody @Valid AirportRequest airportdto){
		Airport airport = airportService.addAirport(new Airport(airportdto.getAirportCode(),airportdto.getAirportName(),airportdto.getAirportLocation()));
		ResponseEntity<Airport> response = new ResponseEntity<Airport>(airport,HttpStatus.OK);
		return response;
	}
	
	/**
	 * Fetching airport and airportDetails
	 * @param airportCode
	 * @return
	 */
	@GetMapping("/getAirport/{id}")
	ResponseEntity<Airport> fetchAirport(@PathVariable("id") String airportCode){
		Airport airport = airportService.fetchAirportById(airportCode);
		ResponseEntity<Airport> response = new ResponseEntity<Airport>(airport,HttpStatus.OK);
		return response;
	}
	
	/**
	 * Fetching all airports
	 * @return
	 */
	@GetMapping
	ResponseEntity<List<Airport>> fetchAllAirports(){
		List<Airport> airports = airportService.fetchAllAirports();
		ResponseEntity<List<Airport>> response = new ResponseEntity<List<Airport>>(airports,HttpStatus.OK);
		return response;
	}
	
	/**
	 * Updating airport
	 * @param airportCode and airportDto
	 * @return
	 */
	@PutMapping("/updateAirport/{id}")
	ResponseEntity<Airport> updateAirport(@PathVariable("id") String airportCode,@RequestBody AirportRequest airportDto){
		Airport airport = new Airport(airportCode,airportDto.getAirportName(),airportDto.getAirportLocation());
		Airport resp=airportService.updateAirport(airport);
		ResponseEntity<Airport> response = new ResponseEntity<Airport>(resp,HttpStatus.OK);
		return response;
	}
	
	/**
	 * Deleting airport
	 * @param airportCode
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Airport> deleteAirport(@PathVariable("id") String airportCode){
		Airport airport=airportService.removeAirport(airportCode);
		ResponseEntity<Airport> response = new ResponseEntity<Airport>(airport,HttpStatus.OK);
		return response;
	}
	
}
