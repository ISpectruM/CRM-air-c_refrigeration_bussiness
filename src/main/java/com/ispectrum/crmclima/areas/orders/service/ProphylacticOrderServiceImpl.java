package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.Utils.DateToLocalDate;
import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.repository.ClientRepository;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.prophulactic_models.ProphylacticBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.ProphylacticOrderDto;
import com.ispectrum.crmclima.areas.orders.repository.ProphylacticOrderRepository;
import com.ispectrum.crmclima.areas.users.entities.User;
import com.ispectrum.crmclima.areas.users.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ProphylacticOrderServiceImpl implements ProphylacticOrderService {

    private final ProphylacticOrderRepository prophylacticRepository;
    private final ClientRepository clientRepository;
    private final UserServiceImpl userDetailsService;

    @Autowired
    public ProphylacticOrderServiceImpl(
            ProphylacticOrderRepository prophylacticRepository,
            ClientRepository clientRepository,
            UserServiceImpl userService) {
        this.prophylacticRepository = prophylacticRepository;
        this.clientRepository = clientRepository;
        this.userDetailsService = userService;
    }


    @Override
    public void saveProphylactic(String clientId, ProphylacticBindingModel bindingModel) {
        Client client = this.clientRepository.findFirstById(clientId);

        ProphylacticOrder newProphylacticOrder =
                ModelMappingUtil.convertClass(bindingModel,ProphylacticOrder.class);

        ProphylacticOrder lastOrder = this.prophylacticRepository.findTopByOrderByOrderNumberDesc();
        Long orderNumber = 0L;
        if (lastOrder != null){
            orderNumber = lastOrder.getOrderNumber();
        }
        newProphylacticOrder.setOrderNumber(orderNumber + 1);


        newProphylacticOrder.setClient(client);

        LocalDate newDate = LocalDate.now();
        if(bindingModel.getProduct() != null){
            newDate = DateToLocalDate.convert(bindingModel.getOrderDate());
        }
        newProphylacticOrder.setOrderDate(newDate);

        Date scheduleDate = bindingModel.getScheduleDate();
        if (scheduleDate != null){
            newProphylacticOrder.setScheduleDate(DateToLocalDate.convert(scheduleDate));
        }

        newProphylacticOrder.setLocation(createLocation(bindingModel));

        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = this.userDetailsService.loadUserByUsername(principal.getName());
        newProphylacticOrder.setUser((User)user);

        this.prophylacticRepository.saveAndFlush(newProphylacticOrder);
    }

    @Override
    public ProphylacticOrderDto getProphylacticById(String id) {
        ProphylacticOrder firstById = this.prophylacticRepository.findFirstById(id);
        return ModelMappingUtil.convertClass(firstById, ProphylacticOrderDto.class);
    }

    @Override
    public boolean editProphylactic(String id, ProphylacticBindingModel bindingModel) {
        return false;
    }

    //Rest service save prophylactic in schedule mode
    @Override
    public void saveProphylacticChanges(RestOrderBindingModel model) {
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

    @Override
    public Page<ProphylacticOrderDto> getAllProphylactics(Pageable pageable) {
        Page<ProphylacticOrder> allProphylactics =
                this.prophylacticRepository.findAllByDeletedOnIsNull(pageable);
        return ModelMappingUtil.convertPage(allProphylactics, ProphylacticOrderDto.class);
    }

    private Location createLocation(BaseOrderBindingModel model) {
        Location location = new Location();
        location.setCity(model.getCity());
        location.setAddress(model.getAddress());
        return location;
    }

}
