package com.ispectrum.crmclima.areas.schedules.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.schedules.models.dtos.ScheduleDto;
import com.ispectrum.crmclima.areas.schedules.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController extends BaseController{

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/create")
    public ModelAndView createSchedule(){
        List<ScheduleDto> allUnfinishedOrders =
                this.scheduleService.getAllUnfinishedOrders();
        return this.addViewAndObject("orders",allUnfinishedOrders,"schedules/create");
    }
}
