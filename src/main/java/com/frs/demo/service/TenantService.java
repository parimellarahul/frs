package com.frs.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frs.demo.entity.Tenant;
import com.frs.demo.exceptions.NoSuchTenantException;

@Service
public interface TenantService {

	Tenant addTenant(Tenant tenant);

	String update(Tenant tenant);

	List<Tenant> viewAllTenants();

	

	Tenant viewTenantById(int tenantid);

	Tenant findTenantById(int tenantId);

	Tenant deleteTenantBytenantid(int tenantid) throws NoSuchTenantException;
}
