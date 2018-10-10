package com.ispectrum.crmclima.areas.schedules.service;

import com.ispectrum.crmclima.areas.schedules.entities.Schedule;
import com.ispectrum.crmclima.areas.schedules.models.bindingModels.AddScheduleBindingModel;
import com.ispectrum.crmclima.areas.schedules.models.dtos.CreateScheduleDto;
import com.ispectrum.crmclima.areas.schedules.models.dtos.ScheduleDto;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    List<CreateScheduleDto> getAllUnfinishedOrders();

    String addSchedule(AddScheduleBindingModel model);

    ScheduleDto getScheduleById(String id);

    List<ScheduleDto> getAllSchedules();

}
