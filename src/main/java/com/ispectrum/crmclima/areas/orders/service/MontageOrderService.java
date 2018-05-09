package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.OrderSaveModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.MontageOrderBindingModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface MontageOrderService {

    void addMontage(String clientId,MontageOrderBindingModel model);

    Page<MontageOrderDto> getAllMontages(Pageable pageable);

    MontageOrderDto getMontageById(String id);

    boolean deleteOrder(String id);

    void editMontage(String id,MontageOrderBindingModel model);

    List<MontageOrderDto> getAllUnfinishedMontagesDtos();

    List<MontageOrder> getAllUnfinishedMontages();

    void saveMontageChanges(OrderSaveModel model);

    Set<MontageOrder> getMontagesByDateNotFinished(LocalDate scheduleDate);

}
