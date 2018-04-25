package com.ispectrum.crmclima.areas.schedules.service;

import com.ispectrum.crmclima.areas.schedules.models.dtos.ScheduleDto;

import java.util.List;

public interface ScheduleService {
    List<ScheduleDto> getAllUnfinishedOrders();
}
