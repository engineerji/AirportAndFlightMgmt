package com.capg.flightmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AirportRequest {

	@NotNull
	@Size(min=3,max=6)
	private String airportCode;
	@NotNull
	@Size(min=3,max=20)
	private String airportName;
	@NotNull
	@Size(min=3,max=15)
	private String airportLocation;
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
	
}
