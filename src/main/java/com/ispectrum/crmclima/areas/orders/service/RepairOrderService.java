package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.RepairBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.RepairOrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface RepairOrderService {

    void saveRepairChanges(RestOrderBindingModel model);

    List<RepairOrder> getUnfinishedRepairs();

    Set<RepairOrder> getRepairsByDate(LocalDate scheduleDate);

    RepairOrder saveRepairOrder(String clientId, RepairBindingModel model);

    Page<RepairOrderDto> getAllRepairs(Pageable pageable);

    RepairOrderDto getRepairById(String id);

    RepairOrder editRepair(String id,RepairBindingModel bindingModel);

    boolean deleteRepair(String id);
}
