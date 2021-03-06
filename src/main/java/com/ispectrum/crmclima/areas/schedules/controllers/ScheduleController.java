package com.ispectrum.crmclima.areas.schedules.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.schedules.models.bindingModels.AddScheduleBindingModel;
import com.ispectrum.crmclima.areas.schedules.models.dtos.CreateScheduleDto;
import com.ispectrum.crmclima.areas.schedules.models.dtos.ScheduleDto;
import com.ispectrum.crmclima.areas.schedules.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
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
        List<CreateScheduleDto> allUnfinishedOrders =
                this.scheduleService.getAllUnfinishedOrders();
        this.addViewAndObject("orders",allUnfinishedOrders,"schedules/create");
        LocalDate scheduleDate = LocalDate.now().plusDays(1);
        return this.addObjectToView("currentDate", scheduleDate);
    }

    @PostMapping("/add")
    public ModelAndView createScheduleAction(AddScheduleBindingModel model){
        String id = this.scheduleService.addSchedule(model);
        return this.redirect("/schedule/details/"+id);
    }

    @GetMapping("/details/{scheduleId}")
    public ModelAndView showScheduleDetails(@PathVariable String scheduleId){
        ScheduleDto scheduleDto =
                this.scheduleService.getScheduleById(scheduleId);
        return this.addViewAndObject("schedule",scheduleDto,"schedules/details");
    }

    @GetMapping("/all")
    public ModelAndView showSchedules(){
        List<ScheduleDto> allSchedules = this.scheduleService.getAllSchedules();
        return this.addViewAndObject("schedules", allSchedules,"schedules/all");
    }
}
