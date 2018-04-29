package com.ispectrum.crmclima.areas.clients.repository;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, String> {

    List<Client> findAllBy();

    Client findFirstById(String id);

    Set<Client> findClientsByPhoneContaining(String phone);

    Set<Client> findClientsByAddressContaining(String address);

    Set<Client> findClientsByNameContaining(String name);

    Page<Client> findAllByOrderByEnterDateDesc(Pageable pageable);
}
