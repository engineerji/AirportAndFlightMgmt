package com.capg.flightmgmt.exceptions;

public class ScheduleNotFoundException extends RuntimeException{
	public ScheduleNotFoundException(String msg) {
		super(msg);
	}
}
