package com.capg.flightmgmt.exceptions;

public class AirportAlreadyExistException extends RuntimeException{
	public AirportAlreadyExistException(String msg) {
		super(msg);
	}

}
