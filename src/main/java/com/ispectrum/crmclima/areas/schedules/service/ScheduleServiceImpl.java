package com.ispectrum.crmclima.areas.schedules.service;

import com.ispectrum.crmclima.Utils.DateToLocalDate;
import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.error_handling.exception.ScheduleAlreadyCreatedException;
import com.ispectrum.crmclima.areas.error_handling.exception.ScheduleNotFound;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.service.ScheduleOrdersMediatorService;
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
import java.util.Set;

@Service
public class ScheduleServiceImpl implements com.ispectrum.crmclima.areas.schedules.service.ScheduleService {
    private final ScheduleOrdersMediatorService baseOrderService;
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleOrdersMediatorService baseOrderService, ScheduleRepository scheduleRepository) {
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
        Boolean isScheduleCreated = this.scheduleRepository.existsByScheduleDate(date);
        if(isScheduleCreated){
            throw new ScheduleAlreadyCreatedException();
        }

        newSchedule.setScheduleDate(date);

        Set<MontageOrder> montagesByScheduleDate = this.baseOrderService.getMontagesByScheduleDate(date);
        newSchedule.setMontageOrders(montagesByScheduleDate);

        Set<RepairOrder> repairsByScheduleDate = this.baseOrderService.getRepairsByScheduleDate(date);
        newSchedule.setRepairOrders(repairsByScheduleDate);

        Set<ProphylacticOrder> prophylacticsByScheduleDate = this.baseOrderService.getProphylacticsByScheduleDate(date);
        newSchedule.setProphylacticOrders(prophylacticsByScheduleDate);

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
        return ModelMappingUtil.convertList(allUnfinishedProphylactics,CreateScheduleDto.class);
    }

    private List<CreateScheduleDto> getAllRepairs() {
        List<RepairOrder> allUnfinishedRepairs =
                this.baseOrderService.getAllUnfinishedRepairs();
        return ModelMappingUtil.convertList(allUnfinishedRepairs,CreateScheduleDto.class);
    }

    private List<CreateScheduleDto> getAllMontages() {
        List<MontageOrder> allUnfinishedMontages =
                this.baseOrderService.getAllUnfinishedMontages();
        return ModelMappingUtil.convertList(allUnfinishedMontages, CreateScheduleDto.class);
    }
}
