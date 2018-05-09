package com.ispectrum.crmclima.areas.orders.repository;

import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface MontageOrderRepository extends PagingAndSortingRepository<MontageOrder,String> {
//    List<MontageOrder> findAllByOrderDateAsc();

    MontageOrder findFirstById(String id);
//Used to show the orders for new schedule
    List<MontageOrder> findAllByIsFinishedAndDeletedOnIsNull(boolean isFinished);
//Used in creating schedule for a specific date
    Set<MontageOrder> findAllByScheduleDateAndIsFinished(LocalDate scheduleDate, boolean isFinished);
//    Used to get the last order number to assign next;
    MontageOrder findTopByOrderByOrderNumberDesc();

    Page<MontageOrder> findAllByDeletedOnIsNull(Pageable pageable);
}
