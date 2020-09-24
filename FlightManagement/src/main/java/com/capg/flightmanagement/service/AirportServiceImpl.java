package com.capg.flightmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.flightmanagement.dao.IAirportDao;
import com.capg.flightmanagement.exceptions.AirportNotFoundException;
import com.capg.flightmanagement.models.Airport;

@Service
@Transactional
public class AirportServiceImpl implements IAirportService{
	
	@Autowired
	private IAirportDao airportDao;

	/**
	 * saving the airport
	 * @param airport
	 * @return
	 */
	@Override
	public Airport addAirport(Airport airport) {
		airport=airportDao.save(airport);
		return airport;
	}

	/**
	 * fetching airport by airportCode
	 * @param airportCode
	 * @return
	 */
	@Override
	public Airport fetchAirportById(String airportCode) {
		Optional<Airport> option= airportDao.findById(airportCode);
		if(!option.isPresent()) {
			throw new AirportNotFoundException("No such Airport exist with AirportCode "+airportCode);
		}
		Airport airport = option.get();
		return airport;
	}

	/**
	 * removing airport by airportCode
	 * @param airportCode
	 * @return
	 */
	@Override
	public void removeAirport(String airportCode) {
		airportDao.delete(fetchAirportById(airportCode));
		
	}

	/**
	 * fetching all airports
	 * @param 
	 * @return
	 */
	@Override
	public List<Airport> fetchAllAirports() {
		List<Airport> airports = airportDao.findAll();
		return airports;
	}
	
	
}
