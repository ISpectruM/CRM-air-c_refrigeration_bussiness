package com.ispectrum.crmclima.areas.users.repository;

import com.ispectrum.crmclima.areas.users.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByAuthority(String authority);
}
