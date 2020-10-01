package com.capg.flightmgmt.service;

import java.util.List;

import com.capg.flightmgmt.entities.Airport;

public interface IAirportService {
	Airport addAirport(Airport airport);
	Airport fetchAirportById(String airportCode);
	List<Airport> fetchAllAirports();
	Airport removeAirport(String airportCode);
	Airport updateAirport(Airport airport);
}
