package com.capg.flightmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.flightmgmt.entities.Schedule;

public interface IScheduleDao extends JpaRepository<Schedule, String>{

}
