package com.ispectrum.crmclima.areas.schedules.repository;

import com.ispectrum.crmclima.areas.schedules.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,String>{
}
