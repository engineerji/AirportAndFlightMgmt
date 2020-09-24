package com.capg.flightmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.flightmanagement.dao.IScheduleDao;
import com.capg.flightmanagement.exceptions.ScheduleNotFoundException;
import com.capg.flightmanagement.models.Schedule;



@Service
@Transactional
public class ScheduleServiceImpl implements IScheduleService {

	@Autowired
	private IScheduleDao scheduleDao;
	
	/**
	 * saving the schedule
	 * @param schedule
	 * @return
	 */
	@Override
	public Schedule addSchedule(Schedule schedule) {
		schedule=scheduleDao.save(schedule);
		return schedule;
	}

	/**
	 * fetch schedule by scheduleId
	 * @param scheduleId
	 * @return
	 */
	@Override
	public Schedule fetchScheduleById(String scheduleId) {
		Optional<Schedule> option= scheduleDao.findById(scheduleId);
		if(!option.isPresent()) {
			throw new ScheduleNotFoundException("No such Schedule exist with ScheduleId "+scheduleId);
		}
		Schedule schedule = option.get();
		return schedule;
	}

	/**
	 * removing the schedule
	 * @param scheduleId
	 * @return
	 */
	@Override
	public void removeSchedule(String scheduleId) {
		scheduleDao.delete(fetchScheduleById(scheduleId));
		
	}
	
	/**
	 * fetching all schedules
	 * @param 
	 * @return
	 */
	@Override
	public List<Schedule> fetchAllSchedules() {
		List<Schedule> schedules = scheduleDao.findAll();
		return schedules;
	}

	

}
