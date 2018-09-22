package com.ispectrum.crmclima.areas.orders.controllers;

import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.ajax.ResponseMessage;
import com.ispectrum.crmclima.areas.orders.service.ScheduleOrdersMediatorService;
import com.ispectrum.crmclima.constants.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrdersRestController {
    private final ScheduleOrdersMediatorService scheduleOrdersMediatorService;

    @Autowired
    public OrdersRestController(ScheduleOrdersMediatorService scheduleOrdersMediatorService){
        this.scheduleOrdersMediatorService = scheduleOrdersMediatorService;
    }

    @PostMapping("/save")
    public ResponseEntity saveOrderChanges(
            @Valid @RequestBody RestOrderBindingModel orderSaveModel, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Found " + errors.getErrorCount() + "errors!");
        }
        this.scheduleOrdersMediatorService.saveOrder(orderSaveModel);
        ResponseMessage message = new ResponseMessage();
        message.setMessage(Messages.SUCCESSFULLY_SAVED);
        return ResponseEntity.ok(message);
    }

//    @GetMapping("/productsAddForm")
//    public ModelAndView getChooseProductFragment(){
//        return new ModelAndView("orders/montages/fragments/productsAddForm");
//    }
}
