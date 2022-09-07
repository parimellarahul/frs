package com.frs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frs.demo.entity.Tenant;



@Repository
public interface ITenantRepository extends JpaRepository<Tenant,Integer>{

	

}
