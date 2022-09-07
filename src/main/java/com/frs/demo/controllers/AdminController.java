package com.frs.demo.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frs.demo.entity.Tenant;
import com.frs.demo.exceptions.NoSuchTenantException;
import com.frs.demo.serviceimplementation.ITenantService;


@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	ITenantService itenantService;

// Add tenants

	@PostMapping("/add-tenants")
	public ResponseEntity<Tenant> add(@RequestBody Tenant tenant) {
		Tenant result = itenantService.addTenant(tenant);
		if (result != null) {
			return new ResponseEntity<Tenant>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Tenant>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//  update tenants

//	@PutMapping("/update-tenants/{tenantid}")
//	public ResponseEntity<Tenant> update(@RequestBody Tenant tenant) {
//		Tenant result = itenantService.update(tenant);
//		if (result != null) {
//			return new ResponseEntity<Tenant>(result, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Tenant>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	
	@PutMapping("/tenants/{tenantid}")  
	public ResponseEntity<String> updateTenant(@RequestBody Tenant tenant) throws NoSuchTenantException{
		String list = itenantService.update(tenant);  
		if(list==null) {
			throw new NoSuchTenantException("No flat is updated!");
		}
		return ResponseEntity.ok(list);
	}
// Delete tenants

	@DeleteMapping("/delete-tenants/{tenantid}")
	public ResponseEntity<?> deleteTenantBytenantid(@Valid @PathVariable int tenantid) throws NoSuchTenantException {
		Tenant result = itenantService.deleteTenantBytenantid(tenantid);
		if (result!=null)
			return new ResponseEntity<>("deleted Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

//  view all tenants

	@GetMapping("/tenants")
	public ResponseEntity<List<Tenant>> viewAllTenants() {
		List<Tenant> result = itenantService.viewAllTenants();
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// view tenant by id

	@GetMapping("/get-tenant-by-id/{tenantId}")
	public ResponseEntity<Tenant> getTenantById(@Valid @PathVariable("tenantId") int tenantId)
			throws NoSuchTenantException {
		Tenant result = itenantService.findTenantById(tenantId);
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}