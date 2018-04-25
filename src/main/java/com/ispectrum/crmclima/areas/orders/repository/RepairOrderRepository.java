package com.ispectrum.crmclima.areas.orders.repository;

import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairOrderRepository extends JpaRepository<RepairOrder, String> {

    List<RepairOrder> findAllByIsFinished(boolean isFinished);
}
