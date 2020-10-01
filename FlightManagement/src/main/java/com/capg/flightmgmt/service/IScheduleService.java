package com.capg.flightmgmt.service;

import java.util.List;

import com.capg.flightmgmt.entities.Schedule;

public interface IScheduleService {

	Schedule addSchedule(Schedule schedule);
	Schedule fetchScheduleById(String scheduleId);
	List<Schedule> fetchAllSchedules();
	Schedule removeSchedule(String scheduleId);
	Schedule updateSchedule(Schedule schedule);
}
