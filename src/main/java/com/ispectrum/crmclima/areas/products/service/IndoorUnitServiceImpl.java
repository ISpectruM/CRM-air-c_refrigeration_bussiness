package com.ispectrum.crmclima.areas.products.service;

import com.ispectrum.crmclima.areas.error_handling.exception.ProductNotFoundException;
import com.ispectrum.crmclima.areas.products.entities.airconditioners.IndoorUnit;
import com.ispectrum.crmclima.areas.products.repository.IndoorUnitRepository;
import com.ispectrum.crmclima.constants.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class IndoorUnitServiceImpl implements IndoorUnitService {
    private IndoorUnitRepository indoorUnitRepository;

    @Autowired
    public IndoorUnitServiceImpl(IndoorUnitRepository repository) {
        this.indoorUnitRepository = repository;
    }

    @Override
    public Page<IndoorUnit> listAllAvailableIndoors(Pageable pageable) {
        return this.indoorUnitRepository.findAllByDeletedOnIsNull(pageable);
    }

    @Override
    public void createIndoorUnit(IndoorUnit unit) {
        indoorUnitRepository.save(unit);
    }

    @Override
    public IndoorUnit getIndoorById(String id) {
        Optional<IndoorUnit> indoorById = indoorUnitRepository.findById(id);

        if (!indoorById.isPresent()) {
            throw new ProductNotFoundException(String.format(id, Messages.INDOOR_NOT_FOUND));
        }
        return indoorById.get();
    }

    @Override
    public void editInDoorUnit(String id, IndoorUnit model) {
        boolean ifUnitExists = this.indoorUnitRepository.existsById(id);
        if (!ifUnitExists) {
            throw new ProductNotFoundException(Messages.INDOOR_NOT_FOUND);
        }

        this.indoorUnitRepository.save(model);
    }

    @Override
    public void deleteIndoor(String id) {
        IndoorUnit indoorUnit = this.indoorUnitRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(Messages.INDOOR_NOT_FOUND));
        indoorUnit.setDeletedOn(LocalDateTime.now());

        this.indoorUnitRepository.save(indoorUnit);
    }
}
