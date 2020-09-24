package com.capg.flightmanagement.service;

import java.util.List;

import com.capg.flightmanagement.models.Airport;

public interface IAirportService {
	Airport addAirport(Airport airport);
	Airport fetchAirportById(String airportCode);
	List<Airport> fetchAllAirports();
	void removeAirport(String airportCode);
}
