package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.OrderSaveModel;
import com.ispectrum.crmclima.areas.orders.repository.RepairOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class RepairOrderServiceImpl implements RepairOrderService {
    private final RepairOrderRepository repairOrderRepository;

    @Autowired
    public RepairOrderServiceImpl(RepairOrderRepository repairOrderRepository) {
        this.repairOrderRepository = repairOrderRepository;
    }

    @Override
    public void saveRepairChanges(OrderSaveModel model) {
//        TODO save changes to DB
    }

    @Override
    public List<RepairOrder> getUnfinishedRepairs() {
        return this.repairOrderRepository.findAll();
    }

    @Override
    public Set<RepairOrder> getRepairsByDate(LocalDate scheduleDate) {
        return this.repairOrderRepository.findAllByScheduleDate(scheduleDate);
    }
}
