package com.ispectrum.crmclima.areas.products.repository;

import com.ispectrum.crmclima.areas.products.entities.airconditioners.AirConditioner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "airconds",path = "airconds")
public interface AirConditionRepository extends JpaRepository<AirConditioner, String> {
    Set<AirConditioner> findAllByBrand(@Param("brand") String brand);

    AirConditioner findFirstByIndoorUnitModel(String model);

    Page<AirConditioner> findAll(Pageable airConditioners);
}
