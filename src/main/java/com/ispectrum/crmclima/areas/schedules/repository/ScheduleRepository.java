package com.ispectrum.crmclima.areas.schedules.repository;

import com.ispectrum.crmclima.areas.schedules.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,String>{
    Schedule findAllByScheduleDate(LocalDate scheduleDate);

    Schedule findFirstById(String id);
}
