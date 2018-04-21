package com.ispectrum.crmclima.areas.orders.repository;

import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MontageOrderRepository extends JpaRepository<MontageOrder,String>{
    Set<MontageOrder> findAllBy();

    MontageOrder findFirstById(String id);

    Set<MontageOrder> findAllByIsFinished(boolean isFinished);
}
