package com.ispectrum.crmclima.areas.clients.repository;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface ClientRepository extends JpaRepository<Client, String>{

    Set<Client> findAllBy();

    Client findFirstById(String id);

    Set<Client> findClientsByPhone(String phone);

    Set<Client> findClientsByAddressContaining(String address);

    Set<Client> findClientsByNameContaining(String name);
}
