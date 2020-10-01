package com.capg.flightmgmt.exceptions;

public class AirportNotFoundException extends RuntimeException{
	public AirportNotFoundException(String msg) {
		super(msg);
	}
}
