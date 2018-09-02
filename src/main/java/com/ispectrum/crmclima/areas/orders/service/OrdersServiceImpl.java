package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

//Main orders service used by schedule and REST controllers
@Service
public class OrdersServiceImpl implements OrdersService {
    private final MontageOrderService montageOrderService;
    private final RepairOrderService repairOrderService;
    private final ProphylacticOrderService prophylacticOrderService;


    @Autowired
    public OrdersServiceImpl(MontageOrderService montageOrderService,
                             RepairOrderService repairOrderService,
                             ProphylacticOrderService prophylacticOrderService){
        this.montageOrderService = montageOrderService;
        this.repairOrderService = repairOrderService;
        this.prophylacticOrderService = prophylacticOrderService;
    }

    @Override
    public List<MontageOrder> getAllUnfinishedMontages() {
       return this.montageOrderService.getAllUnfinishedMontages();
    }

    @Override
    public List<RepairOrder> getAllUnfinishedRepairs() {
        return this.repairOrderService.getUnfinishedRepairs();
    }

    @Override
    public List<ProphylacticOrder> getAllUnfinishedProphylactics() {
        return this.prophylacticOrderService.getUnfinishedProphylactics();
    }

    @Override
    public void saveOrder(RestOrderBindingModel model) {
        String service = model.getType();

        switch (service){
            case "montage":
                this.editMontage(model);
                break;
            case "repair":
                this.editRepair(model);
                break;
            case "prophylactic":
                this.editProphylactic(model);
                break;
        }
    }

    @Override
    public Set<MontageOrder> getMontagesByScheduleDate(LocalDate scheduleDate) {
        return this.montageOrderService.getMontagesByDateNotFinished(scheduleDate);
    }

    @Override
    public Set<RepairOrder> getRepairsByScheduleDate(LocalDate scheduleDate) {
        return this.repairOrderService.getRepairsByDate(scheduleDate);
    }

    @Override
    public Set<ProphylacticOrder> getProphylacticsByScheduleDate(LocalDate scheduleDate) {
        return this.prophylacticOrderService.getProphylacticsByDate(scheduleDate);
    }

    private void editProphylactic(RestOrderBindingModel model) {
        this.prophylacticOrderService.saveProphylacticChanges(model);
    }

    private void editRepair(RestOrderBindingModel model) {
        this.repairOrderService.saveRepairChanges(model);
    }

    private void editMontage(RestOrderBindingModel model) {
        this.montageOrderService.saveScheduleMontageChanges(model);
    }
}
