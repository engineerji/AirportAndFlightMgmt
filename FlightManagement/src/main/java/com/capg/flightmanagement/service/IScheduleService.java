package com.capg.flightmanagement.service;

import java.util.List;

import com.capg.flightmanagement.models.Schedule;

public interface IScheduleService {

	Schedule addSchedule(Schedule schedule);
	Schedule fetchScheduleById(String scheduleId);
	List<Schedule> fetchAllSchedules();
	void removeSchedule(String scheduleId);
}
