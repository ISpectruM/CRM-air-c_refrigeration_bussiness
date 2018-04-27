package com.ispectrum.crmclima.areas.schedules.service;

import com.ispectrum.crmclima.Utils.DateToLocalDate;
import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.error_handling.exception.ScheduleNotFound;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.service.OrdersService;
import com.ispectrum.crmclima.areas.schedules.entities.Schedule;
import com.ispectrum.crmclima.areas.schedules.models.bindingModels.AddScheduleBindingModel;
import com.ispectrum.crmclima.areas.schedules.models.dtos.CreateScheduleDto;
import com.ispectrum.crmclima.areas.schedules.models.dtos.ScheduleDto;
import com.ispectrum.crmclima.areas.schedules.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final OrdersService baseOrderService;
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(OrdersService baseOrderService, ScheduleRepository scheduleRepository) {
        this.baseOrderService = baseOrderService;
        this.scheduleRepository = scheduleRepository;
    }


    @Override
    public List<CreateScheduleDto> getAllUnfinishedOrders() {
        List<CreateScheduleDto> allOrders = new ArrayList<>();

        allOrders.addAll(getAllMontages());
        allOrders.addAll(getAllRepairs());
        allOrders.addAll(getAllProphylactics());

        return allOrders;
    }

    @Override
    public String addSchedule(AddScheduleBindingModel model) {
        Schedule newSchedule = new Schedule();
        LocalDate date = DateToLocalDate.convert(model.getScheduleDate());
        newSchedule.setScheduleDate(date);
        newSchedule.setMontageOrders(
                this.baseOrderService.getMontagesByScheduleDate(date));
        newSchedule.setRepairOrders(
                this.baseOrderService.getRepairsByScheduleDate(date));
        newSchedule.setProphylacticOrders(
                this.baseOrderService.getProphylacticsByScheduleDate(date));

        Schedule schedule = this.scheduleRepository.saveAndFlush(newSchedule);
        return schedule.getId();
    }

    @Override
    public ScheduleDto getScheduleById(String id) {
        Schedule schedule = this.scheduleRepository.findFirstById(id);
        if (schedule == null){
            throw new ScheduleNotFound();
        }
        return ModelMappingUtil.convertClass(schedule,ScheduleDto.class);
    }

    @Override
    public List<ScheduleDto> getAllSchedules() {
        List<Schedule> all = this.scheduleRepository.findAll();
        return ModelMappingUtil.convertList(all,ScheduleDto.class);
    }

    private List<CreateScheduleDto> getAllProphylactics() {
        List<ProphylacticOrder> allUnfinishedProphylactics =
                this.baseOrderService.getAllUnfinishedProphylactics();
//        ModelMappingUtil.convertList(allUnfinishedProphylactics,CreateScheduleDto.class);
        return new ArrayList<>();
    }

    private List<CreateScheduleDto> getAllRepairs() {
        List<RepairOrder> allUnfinishedRepairs =
                this.baseOrderService.getAllUnfinishedRepairs();
//        ModelMappingUtil.convertList(allUnfinishedRepairs,CreateScheduleDto.class);
        return new ArrayList<>();
    }

    private List<CreateScheduleDto> getAllMontages() {
        List<MontageOrder> allUnfinishedMontages =
                this.baseOrderService.getAllUnfinishedMontages();
        return ModelMappingUtil.convertList(allUnfinishedMontages, CreateScheduleDto.class);
    }
}
