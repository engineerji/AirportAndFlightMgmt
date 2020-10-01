package com.capg.flightmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Airport {

	@NotNull
	@Size(min=3)
	@Id
	private String airportCode;
	@NotNull
	@Size(min=3,max=20)
	private String airportName;
	@NotNull
	@Size(min=3,max=15)
	private String airportLocation;
	public Airport() {}
	
	public Airport(String airportCode, String airportName, String airportLocation) {
		super();
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	@Override
	public int hashCode() {
		return airportCode.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || obj instanceof Airport)
			return false;
		Airport other=(Airport) obj;
		return this.airportCode.equals(other.airportCode);
	}
	
}
