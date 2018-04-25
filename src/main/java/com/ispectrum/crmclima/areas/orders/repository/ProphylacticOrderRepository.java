package com.ispectrum.crmclima.areas.orders.repository;

import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface ProphylacticOrderRepository extends JpaRepository<ProphylacticOrder, String>{
    List<ProphylacticOrder> findAllByIsFinished(boolean isFinished);

    Set<ProphylacticOrder> findAllByScheduleDate(LocalDate scheduleDate);
}
