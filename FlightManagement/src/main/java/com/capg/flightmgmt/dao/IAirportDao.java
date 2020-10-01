package com.capg.flightmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.flightmgmt.entities.Airport;

public interface IAirportDao extends JpaRepository<Airport, String>{
	public Airport findByAirportLocation(String location);

}
