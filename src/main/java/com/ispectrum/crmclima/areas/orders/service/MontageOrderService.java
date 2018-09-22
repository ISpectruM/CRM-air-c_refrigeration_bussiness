package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models.EditMontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models.OfferViewBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models.MontageOrderBindingModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface MontageOrderService extends BaseOrderService{

    void addMontage(String clientId,MontageOrderBindingModel model);

    boolean addOfferView(String clientId,OfferViewBindingModel model);

    void editMontage(String id,EditMontageOrderBindingModel model);

    boolean deleteMontage(String id);

    MontageOrder getMontageById(String id);

    MontageOrderDto getMontageDtoById(String id);

    Page<MontageOrderDto> getAllMontages(Pageable pageable);

    List<MontageOrder> getAllUnfinishedMontages();

    Set<MontageOrder> getMontagesByScheduleDateNotFinished(LocalDate scheduleDate);

    Integer getAllUnfinishedMontagesCount();

}
