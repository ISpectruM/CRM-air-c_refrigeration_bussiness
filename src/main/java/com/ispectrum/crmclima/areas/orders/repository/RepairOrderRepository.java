package com.ispectrum.crmclima.areas.orders.repository;

import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface RepairOrderRepository extends JpaRepository<RepairOrder, String> {

    List<RepairOrder> findAllByIsFinishedIsFalseAndDeletedOnIsNull();

    Set<RepairOrder> findAllByScheduleDate(LocalDate scheduleDate);

    Page<RepairOrder> findAllByDeletedOnIsNull(Pageable pageable);

    RepairOrder findFirstById(String id);

    RepairOrder findTopByOrderByOrderNumberDesc();

    Integer countByIsFinishedIsFalseAndDeletedOnIsNull();
}
