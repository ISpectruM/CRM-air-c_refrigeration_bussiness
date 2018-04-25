package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.OrderSaveModel;
import com.ispectrum.crmclima.areas.orders.repository.ProphylacticOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class ProphylacticOrderServiceImpl implements ProphylacticOrderService {

    private final ProphylacticOrderRepository prophylacticRepository;

    @Autowired
    public ProphylacticOrderServiceImpl(ProphylacticOrderRepository prophylacticRepository) {
        this.prophylacticRepository = prophylacticRepository;
    }


    @Override
    public void saveProphylacticChanges(OrderSaveModel model) {
//        TODO save changes to DB
    }

    @Override
    public List<ProphylacticOrder> getUnfinishedProphylactics() {
        return this.prophylacticRepository.findAllByIsFinished(false);
    }

    @Override
    public Set<ProphylacticOrder> getProphylacticsByDate(LocalDate scheduleDate) {
        return this.prophylacticRepository.findAllByScheduleDate(scheduleDate);
    }
}
