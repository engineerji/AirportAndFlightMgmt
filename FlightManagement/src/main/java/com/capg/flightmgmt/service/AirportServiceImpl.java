package com.capg.flightmgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.flightmgmt.dao.IAirportDao;
import com.capg.flightmgmt.entities.Airport;
import com.capg.flightmgmt.exceptions.AirportAlreadyExistException;
import com.capg.flightmgmt.exceptions.AirportNotFoundException;

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
		Optional<Airport> option= airportDao.findById(airport.getAirportCode());
		if(option.isPresent()) {
			throw new AirportAlreadyExistException("Airport Already exist with Airport Code: "+airport.getAirportCode());
		}
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
	public Airport removeAirport(String airportCode) {
		Airport airport = fetchAirportById(airportCode);
		airportDao.delete(airport);
		return airport;
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

	/**
	 * updating airport
	 * @param airport
	 * @return
	 */
	@Override
	public Airport updateAirport(Airport airport) {
		fetchAirportById(airport.getAirportCode());
		airportDao.save(airport);
		return airport;
	}
	
	
}
