package com.ispectrum.crmclima.areas.orders.controllers;

import com.ispectrum.crmclima.areas.orders.models.ajax.OrderSaveModel;
import com.ispectrum.crmclima.areas.orders.models.ajax.ResponseMessage;
import com.ispectrum.crmclima.areas.orders.service.OrdersService;
import com.ispectrum.crmclima.constants.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrdersRestController {
    private final OrdersService ordersService;

    @Autowired
    public OrdersRestController(OrdersService ordersService){
        this.ordersService = ordersService;
    }

    @PostMapping("/save")
    public ResponseEntity saveOrderChanges(
            @Valid @RequestBody OrderSaveModel orderSaveModel, Errors errors
    ){
        this.ordersService.saveOrder(orderSaveModel);
        ResponseMessage message = new ResponseMessage();
        message.setMessage(Messages.SUCCESSFULLY_SAVED);
        return  ResponseEntity.ok(message);
    }

    @GetMapping("/productsAddForm")
    public ModelAndView getChooseProductFragment(){
        return new ModelAndView("orders/montages/fragments/productsAddForm");
    }
}
