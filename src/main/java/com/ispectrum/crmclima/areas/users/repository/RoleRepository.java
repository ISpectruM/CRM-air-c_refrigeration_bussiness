package com.ispectrum.crmclima.areas.users.repository;

import com.ispectrum.crmclima.areas.users.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

    Role findFirstByAuthority(String authority);

}
