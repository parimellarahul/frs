package com.frs.demo.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frs.demo.entity.Tenant;
import com.frs.demo.exceptions.NoSuchTenantException;
import com.frs.demo.repository.ITenantRepository;
import com.frs.demo.service.TenantService;



@Service
public class ITenantService implements TenantService {

	@Autowired
	ITenantRepository itenantRepository;

	@Override
	public Tenant addTenant(Tenant tenant) {
		// TODO Auto-generated method stub
		return itenantRepository.save(tenant);
	}

//	@Override
//	public Tenant update(Tenant tenant) {
//		// TODO Auto-generated method stub
//		return itenantRepository.save(tenant);
//	}
	public String updateFlat(Tenant tenant) {
		String message="Flat is updated successfully";
		Tenant t=itenantRepository.save(tenant);
		if(t==null) {
			return "flat is not updated";
		}
		return message;
	}


	@Override
	public List<Tenant> viewAllTenants() {
		// TODO Auto-generated method stub
		return (List<Tenant>) itenantRepository.findAll();
	}

	@Override
	public Tenant deleteTenantBytenantid(int tenantid) throws NoSuchTenantException{
	
	Tenant tenant =findTenantById(tenantid);
	itenantRepository.delete(tenant);
	return tenant;
	}

	@Override
	public Tenant findTenantById( int tenantId) {
		// TODO Auto-generated method stub
		return itenantRepository.findById(tenantId).get();
	}

	@Override
	public Tenant viewTenantById(int tenantid) {
	// TODO Auto-generated method stub
	return null;
}

	@Override
	public String update(Tenant tenant) {
		// TODO Auto-generated method stub
		return null;
	}

	

}