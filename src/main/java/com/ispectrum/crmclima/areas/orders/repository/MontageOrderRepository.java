package com.ispectrum.crmclima.areas.orders.repository;

import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MontageOrderRepository extends PagingAndSortingRepository<MontageOrder,String> {
//    List<MontageOrder> findAllByOrderDateAsc();

    MontageOrder findFirstById(String id);

    List<MontageOrder> findAllByIsFinished(boolean isFinished);
}
