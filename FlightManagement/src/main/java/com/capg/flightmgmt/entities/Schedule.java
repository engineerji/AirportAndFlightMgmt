package com.capg.flightmgmt.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Schedule {
	@NotNull
	@Size(min=3,max=10)
	@Id
	private String scheduleId;
	@NotNull
	@OneToOne
	private Airport sourceAirport;
	@NotNull
	@OneToOne
	private Airport destinationAirport;
	@NotNull
	private LocalDateTime arrivalTime;
	@NotNull
	private LocalDateTime departureTime;
	
	public Schedule() {}
	public Schedule(String scheduleId, Airport sourceAirport, Airport destinationAirport, LocalDateTime arrivalTime,
			LocalDateTime departureTime) {
		super();
		this.scheduleId=scheduleId;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	
	
	public String getScheduleId() {
		return scheduleId;
	}


	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}


	public Airport getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}


	@Override
	public int hashCode() {
		return scheduleId.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Schedule other = (Schedule)obj;
		return this.scheduleId.equals(other.scheduleId);
	}
	
	
	

}
