package com.capg.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.flightmanagement.models.Airport;

public interface IAirportDao extends JpaRepository<Airport, String>{

}
