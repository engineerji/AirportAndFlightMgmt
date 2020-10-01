package com.capg.flightmgmt.exceptions;

public class ScheduleAlreadyExistException extends RuntimeException{
	public ScheduleAlreadyExistException(String msg) {
		super(msg);
	}

}
