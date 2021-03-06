package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.repair_models.RepairBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.RepairOrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface RepairOrderService extends BaseOrderService{

    RepairOrderDto getRepairById(String id);

    RepairOrder saveRepairOrder(String clientId, RepairBindingModel model);

    RepairOrder editRepair(String id,RepairBindingModel bindingModel);

    boolean deleteRepair(String id);

    Page<RepairOrderDto> getAllRepairs(Pageable pageable);

    List<RepairOrder> getUnfinishedRepairs();

    Set<RepairOrder> getRepairsByScheduleDateNotFinished(LocalDate scheduleDate);

    Integer getAllUnfinishedRepairsCount();
}
