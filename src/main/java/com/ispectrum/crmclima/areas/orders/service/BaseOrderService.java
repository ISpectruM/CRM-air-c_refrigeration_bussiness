package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.error_handling.exception.MontageNotFoundException;
import com.ispectrum.crmclima.areas.orders.entities.BaseOrder;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface BaseOrderService {
    default boolean deleteOrder(BaseOrder order, CrudRepository repository){
        try{
            if (order == null){
                throw new MontageNotFoundException();
            }

            order.setDeletedOn(LocalDate.now());
            repository.save(order);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
