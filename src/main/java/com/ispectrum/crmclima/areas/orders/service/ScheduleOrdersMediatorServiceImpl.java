package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.Utils.DateToLocalDate;
import com.ispectrum.crmclima.areas.error_handling.exception.MontageNotFoundException;
import com.ispectrum.crmclima.areas.orders.entities.BaseOrder;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.repository.MontageOrderRepository;
import com.ispectrum.crmclima.areas.orders.repository.ProphylacticOrderRepository;
import com.ispectrum.crmclima.areas.orders.repository.RepairOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ScheduleOrdersMediatorServiceImpl implements ScheduleOrdersMediatorService {
    private final MontageOrderService montageOrderService;
    private final RepairOrderService repairOrderService;
    private final ProphylacticOrderService prophylacticOrderService;

    private final MontageOrderRepository montageOrderRepository;
    private final RepairOrderRepository repairOrderRepository;
    private final ProphylacticOrderRepository prophylacticOrderRepository;


    @Autowired
    public ScheduleOrdersMediatorServiceImpl(MontageOrderService montageOrderService,
                                             RepairOrderService repairOrderService,
                                             ProphylacticOrderService prophylacticOrderService, MontageOrderRepository montageOrderRepository, RepairOrderRepository repairOrderRepository, ProphylacticOrderRepository prophylacticOrderRepository){
        this.montageOrderService = montageOrderService;
        this.repairOrderService = repairOrderService;
        this.prophylacticOrderService = prophylacticOrderService;
        this.montageOrderRepository = montageOrderRepository;
        this.repairOrderRepository = repairOrderRepository;
        this.prophylacticOrderRepository = prophylacticOrderRepository;
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
        BaseOrder editedOrder = null;
        switch (service){
            case "montage":
                MontageOrder montage = this.montageOrderRepository.findFirstById(model.getId());
                editedOrder = this.editOrders(montage, model);
                this.montageOrderRepository.save((MontageOrder)editedOrder);
                break;
            case "repair":
                RepairOrder repairOrder = this.repairOrderRepository.findFirstById(model.getId());
                editedOrder = this.editOrders(repairOrder, model);
                this.repairOrderRepository.save((RepairOrder)editedOrder);
                break;
            case "prophylactic":
                ProphylacticOrder prophylacticOrder = this.prophylacticOrderRepository.findFirstById(model.getId());
                editedOrder = this.editOrders(prophylacticOrder, model);
                this.prophylacticOrderRepository.save((ProphylacticOrder)editedOrder);
                break;
        }
    }

    @Override
    public Set<MontageOrder> getMontagesByScheduleDate(LocalDate scheduleDate) {
        return this.montageOrderService.getMontagesByScheduleDateNotFinished(scheduleDate);
    }

    @Override
    public Set<RepairOrder> getRepairsByScheduleDate(LocalDate scheduleDate) {
        return this.repairOrderService.getRepairsByScheduleDateNotFinished(scheduleDate);
    }

    @Override
    public Set<ProphylacticOrder> getProphylacticsByScheduleDate(LocalDate scheduleDate) {
        return this.prophylacticOrderService.getProphylacticsByScheduleDate(scheduleDate);
    }

    private BaseOrder editOrders(BaseOrder order, RestOrderBindingModel model){
        if (order == null){
            throw new MontageNotFoundException();
        }
//        Set new status
        order.setIsDeferred(model.getStatus().getIsDeferred());
        order.setIsFinished(model.getStatus().getIsFinished());
        order.setIsForFinishing(model.getStatus().getIsForFinishing());
        order.setIsMarked(model.getStatus().getIsMarked());
        order.setIsPayed(model.getStatus().getIsPayed());
        order.setIsWaiting(model.getStatus().getIsWaiting());
        order.setIsWithInvoice(model.getStatus().getIsWithInvoice());

        if (order.getIsFinished()){
            order.setEndDate(LocalDate.now());
        }
        Date newDate = model.getScheduleDate();
        if(newDate != null){
            LocalDate date = DateToLocalDate.convert(newDate);
            order.setScheduleDate(date);
        }
        return order;
    }
}
