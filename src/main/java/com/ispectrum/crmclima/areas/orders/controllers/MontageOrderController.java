package com.ispectrum.crmclima.areas.orders.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.orders.entities.enums.MontageType;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models.EditMontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models.MontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models.OfferViewBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.service.MontageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/orders/montages")
public class MontageOrderController extends BaseController {
    private final MontageOrderService montageOrderService;
    private final ClientService clientService;

    @Autowired
    public MontageOrderController(MontageOrderService montageOrderService, ClientService clientService) {
        this.montageOrderService = montageOrderService;
        this.clientService = clientService;
    }

    //Show all montage, offer or view orders
    @GetMapping("/all")
    public ModelAndView getAllMontages(
            @PageableDefault(sort = {"orderNumber"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<MontageOrderDto> allMontages = this.montageOrderService.getAllMontages(pageable);
        this.addViewAndObject("objects", allMontages, "orders/montages/all");
        return this.addObject("area", "orders/montages");
    }

    //Show add order view for client
    @GetMapping("/add/{clientId}")
    public ModelAndView addOrder(@PathVariable String clientId) {
        this.setView("orders/montages/add_montage");
        ClientDto client = this.clientService.getClientById(clientId);
        this.addObject("bindingModel", new MontageOrderBindingModel());
        this.addObject("currentDate", LocalDate.now());
        return this.addObject("client", client);
    }

    //Add montage order
    @PostMapping("/montage/add/{clientId}")
    public ModelAndView addMontageAction(
            @PathVariable String clientId,
            @Valid @ModelAttribute(name = "bindingModel") MontageOrderBindingModel bindingModel,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return getErrorsViewModel(clientId, bindingResult, "add");
        }
        this.montageOrderService.addMontage(clientId, bindingModel);
        return this.redirect("/orders/montages/all?page=0");
    }

    //Add offer or view order
    @PostMapping("/offer/add/{id}")
    public ModelAndView addOrderAction(
            @PathVariable String id,
            @Valid @ModelAttribute(name = "bindingModel") OfferViewBindingModel bindingModel,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return getErrorsViewModel(id, bindingResult, "add");
        }
        this.montageOrderService.addOfferView(id, bindingModel);
        return this.redirect("/orders/montages/all?page=0");
    }

    //Show order details view
    @GetMapping("/details/{id}")
    public ModelAndView getMontageDetails(@PathVariable String id) {
        MontageOrderDto montage = this.montageOrderService.getMontageById(id);
        return this.addViewAndObject("order", montage, "orders/details");
    }

    //Get edit view for montage, offer and view orders
    @GetMapping("/edit/{id}")
    public ModelAndView editOrder(@PathVariable String id) {
        MontageOrderDto montage = this.montageOrderService.getMontageById(id);

        this.addViewAndObject("montage", montage, "orders/montages/edit");
        return this.addObject("bindingModel", new MontageOrderBindingModel());
    }

    //Edit montage
    @PostMapping("/montage/edit/{id}")
    public ModelAndView editMontageOrderAction(@PathVariable String id,
                                       @Valid @ModelAttribute(name = "bindingModel") EditMontageOrderBindingModel model,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return this.getErrorsViewModel(id,bindingResult, "edit");
        }
        this.montageOrderService.editMontage(id, model);
        return this.redirect("/orders/montages/details/" + id);
    }

    //Edit offer or view
    @PostMapping("/offer/edit/{id}")
    public ModelAndView editOfferOrderAction(@PathVariable String id,
                                        EditMontageOrderBindingModel model) {
        this.montageOrderService.editMontage(id, model);
        return this.redirect("/orders/montages/details/" + id);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteOrder(@PathVariable String id) {
        MontageOrderDto montage = this.montageOrderService.getMontageById(id);
        return this.addViewAndObject("montage", montage, "orders/montages/delete");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteOrderAction(@PathVariable String id) {
        this.montageOrderService.deleteOrder(id);
        return this.redirect("/orders/montages/all?page=0");
    }

    private ModelAndView getErrorsViewModel(String id, BindingResult bindingResult, String orderAction) {
        Map<String, Object> model = bindingResult.getModel();
        if (orderAction.equals("add")){
            ClientDto client = this.clientService.getClientById(id);
            model.put("client", client);
        }
        model.put("currentDate", LocalDate.now());
        return this.addViewAndObjectsMap("orders/montages/add_montage", model);
    }

}
