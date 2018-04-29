package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.Utils.DateToLocalDate;
import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.error_handling.exception.ClientNotFoundException;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.entities.enums.RepairType;
import com.ispectrum.crmclima.areas.orders.models.ajax.OrderSaveModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.RepairBindingModel;
import com.ispectrum.crmclima.areas.orders.repository.RepairOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class RepairOrderServiceImpl implements RepairOrderService {
    private final RepairOrderRepository repairOrderRepository;
    private final ClientService clientService;

    @Autowired
    public RepairOrderServiceImpl(RepairOrderRepository repairOrderRepository, ClientService clientService) {
        this.repairOrderRepository = repairOrderRepository;
        this.clientService = clientService;
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

    @Override
    public RepairOrder saveRepairOrder(String clientId, RepairBindingModel model) {
        RepairOrder newOrder = ModelMappingUtil.convertClass(model, RepairOrder.class);

        if(model.getScheduleDate() != null){
            newOrder.setOrderDate(DateToLocalDate.convert(model.getOrderDate()));
        }

        Client pureClientById = this.clientService.getPureClientById(clientId);
        if(pureClientById == null){
            throw new ClientNotFoundException();
        }
        newOrder.setClient(pureClientById);

        if (model.getScheduleDate() != null){
            newOrder.setEndDate(DateToLocalDate.convert(model.getScheduleDate()));
        }

        Location location = ModelMappingUtil.convertClass(model,Location.class);
        newOrder.setLocation(location);

        return this.repairOrderRepository.save(newOrder);
    }
}
