package com.capg.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.flightmanagement.models.Schedule;

public interface IScheduleDao extends JpaRepository<Schedule, String>{

}
