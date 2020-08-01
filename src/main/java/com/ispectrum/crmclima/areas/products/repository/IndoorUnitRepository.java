package com.ispectrum.crmclima.areas.products.repository;

import com.ispectrum.crmclima.areas.products.entities.airconditioners.IndoorUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndoorUnitRepository extends JpaRepository<IndoorUnit, String> {

    Page<IndoorUnit> findAllByDeletedOnIsNull(Pageable pageable);
}
