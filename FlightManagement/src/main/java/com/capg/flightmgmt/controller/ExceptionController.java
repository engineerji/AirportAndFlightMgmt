package com.capg.flightmgmt.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.flightmgmt.dto.ExceptionResponse;
import com.capg.flightmgmt.exceptions.AirportAlreadyExistException;
import com.capg.flightmgmt.exceptions.AirportNotFoundException;
import com.capg.flightmgmt.exceptions.ScheduleAlreadyExistException;
import com.capg.flightmgmt.exceptions.ScheduleNotFoundException;

@RestControllerAdvice
public class ExceptionController {

	private static final Logger Log = LoggerFactory.getLogger(AirportController.class);
	
	/**
	 * Handling AirportNotFoundException,ScheduleNotFound
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = {AirportNotFoundException.class,ScheduleNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleNotFoundException(Exception ex, HttpServletRequest request) {
		Log.error("Not Found Exception",ex);
		return new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
		
	}
	@ExceptionHandler(value = {AirportAlreadyExistException.class,ScheduleAlreadyExistException.class})
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ExceptionResponse handleNotAlreadyException(Exception ex, HttpServletRequest request) {
		Log.error("Not Found Exception",ex);
		return new ExceptionResponse(new Date(), HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
		
	}
	
	/**
	 * Handling Exceptions
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = {Exception.class})
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleOtherException(Exception ex, HttpServletRequest request) {
		Log.error("Not Found Exception",ex);
		return new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
		
	}
	

}
