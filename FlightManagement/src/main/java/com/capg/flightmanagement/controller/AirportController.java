package com.capg.flightmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.flightmanagement.dto.AirportRequest;
import com.capg.flightmanagement.exceptions.AirportNotFoundException;
import com.capg.flightmanagement.models.Airport;
import com.capg.flightmanagement.service.IAirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {
	
	private static final Logger Log = LoggerFactory.getLogger(AirportController.class);

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
	ResponseEntity<Boolean> updateAirport(@PathVariable("id") String airportCode,@RequestBody AirportRequest airportDto){
		Airport airport = airportService.fetchAirportById(airportCode);
		airport.setAirportName(airportDto.getAirportName());
		airport.setAirportLocation(airportDto.getAirportLocation());
		airportService.addAirport(airport);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true,HttpStatus.OK);
		return response;
	}
	
	/**
	 * Deleting airport
	 * @param airportCode
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Boolean> deleteAirport(@PathVariable("id") String airportCode){
		airportService.removeAirport(airportCode);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true,HttpStatus.OK);
		return response;
	}
	
	/**
	 * Handling AirportNotFoundException
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(AirportNotFoundException.class)
	public ResponseEntity<String> handleTicketNotFoundException(AirportNotFoundException exception){
		 Log.error("Airport Exception",exception);
		 String msg = exception.getMessage();
	     ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	     return response;
	}
	
	/**
	 * Handling Exceptions
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleAll(Throwable ex) {
        Log.error("exception caught", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}
