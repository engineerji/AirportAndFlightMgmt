package com.capg.flightmgmt;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.flightmgmt.exceptions.ScheduleNotFoundException;
import com.capg.flightmgmt.entities.Schedule;
import com.capg.flightmgmt.service.IScheduleService;

@SpringBootTest
public class ScheduleTests {
	
	@Autowired
	private IScheduleService scheduleService;
	
	private Schedule schedule ;
	
	@BeforeAll
	public void setUp() {
		schedule = new Schedule("S485",null,null,LocalDateTime.parse("2018-05-16T14:56:50"),LocalDateTime.parse("2019-06-18T22:45:03"));
		this.scheduleService.addSchedule(schedule);
	}
	
	@Test
	public void fetchSchedule_1() {
		Schedule result = scheduleService.fetchScheduleById("S485");
		Assertions.assertEquals(result, schedule);
	}
	
	@Test
	public void fetchSchedule_2() {
		Executable executable = () -> scheduleService.fetchScheduleById("S46");
		Assertions.assertThrows(ScheduleNotFoundException.class, executable);
	}
	
	@Test
	public void deleteAirport_1() {
		String executable = scheduleService.removeSchedule("S4857");
		String expected="Deleted";
		Assertions.assertEquals(expected, executable);
	}
	
	@Test public void deleteAirport_2() {
		Executable executable = () -> scheduleService.removeSchedule("S46");
		Assertions.assertThrows(ScheduleNotFoundException.class, executable);
	}
	
	@Test
	public void updateAirport_1() {
		Schedule schedule = new Schedule("S485",null,null,LocalDateTime.parse("2018-05-16T14:56:50"),LocalDateTime.parse("2019-06-18T22:45:03"));
		String actual = scheduleService.updateSchedule(schedule);
		String expected="Updated";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test public void updateAirport_2() {
		Schedule schedule = new Schedule("S4896",null,null,LocalDateTime.parse("2018-05-16T14:56:50"),LocalDateTime.parse("2019-06-18T22:45:03"));
		Executable executable = () -> scheduleService.updateSchedule(schedule);
		Assertions.assertThrows(ScheduleNotFoundException.class, executable);
	}

}
