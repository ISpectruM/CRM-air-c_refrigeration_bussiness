package com.ispectrum.crmclima.areas.schedules.repository;

import com.ispectrum.crmclima.areas.schedules.entities.Schedule;
import org.modelmapper.internal.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,String>{
    Schedule findAllByScheduleDate(LocalDate scheduleDate);

    Schedule findFirstById(String id);

    Boolean existsByScheduleDate(LocalDate scheduleDate);
}
