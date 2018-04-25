package com.ispectrum.crmclima.areas.schedules.service;

import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.service.OrdersService;
import com.ispectrum.crmclima.areas.schedules.models.dtos.ScheduleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final OrdersService baseOrderService;

    @Autowired
    public ScheduleServiceImpl(OrdersService baseOrderService) {
        this.baseOrderService = baseOrderService;
    }

    @Override
    public List<ScheduleDto> getAllUnfinishedOrders() {
        List<ScheduleDto> allOrders = new ArrayList<>();

        allOrders.addAll(getAllMontages());
        allOrders.addAll(getAllRepairs());
        allOrders.addAll(getAllProphylactics());

        return allOrders;
    }

    private List<ScheduleDto> getAllProphylactics() {
        List<ProphylacticOrder> allUnfinishedProphylactics =
                this.baseOrderService.getAllUnfinishedProphylactics();
//        ModelMappingUtil.convertList(allUnfinishedProphylactics,ScheduleDto.class);
        return new ArrayList<>();
    }

    private List<ScheduleDto> getAllRepairs() {
        List<RepairOrder> allUnfinishedRepairs =
                this.baseOrderService.getAllUnfinishedRepairs();
//        ModelMappingUtil.convertList(allUnfinishedRepairs,ScheduleDto.class);
        return new ArrayList<>();
    }

    private List<ScheduleDto> getAllMontages() {
        List<MontageOrder> allUnfinishedMontages =
                this.baseOrderService.getAllUnfinishedMontages();
        return ModelMappingUtil.convertList(allUnfinishedMontages, ScheduleDto.class);
    }
}
