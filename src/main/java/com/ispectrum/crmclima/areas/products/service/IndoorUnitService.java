package com.ispectrum.crmclima.areas.products.service;

import com.ispectrum.crmclima.areas.products.entities.airconditioners.IndoorUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IndoorUnitService {

    Page<IndoorUnit> listAllAvailableIndoors(Pageable pageable);
    void createIndoorUnit(IndoorUnit model);
    IndoorUnit getIndoorById(String id);
    void editInDoorUnit(String id, IndoorUnit model);
    void deleteIndoor(String id);
}
