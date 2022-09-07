package com.frs.demo.controllers;

import java.util.List;

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

import com.frs.demo.entity.Landlord;
import com.frs.demo.exceptions.LandlordNotFoundException;
import com.frs.demo.service.LandlordService;



@RestController
@RequestMapping("/landlord")
public class LandlordController {
	@Autowired
	LandlordService landlordService;
	
	//Add Landlord
	@PostMapping("/add-landlord")
	public ResponseEntity<Landlord> addLandlord(@RequestBody Landlord landlord)
	{
		System.out.println("hello");
		Landlord result=landlordService.addLandlord(landlord);
		if(result!=null) {
			return new ResponseEntity<Landlord>(result,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<Landlord>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	//Update Landlord
	@PutMapping("/update-landlord")  
	public ResponseEntity<Landlord> updateLandlord(@RequestBody Landlord landlord)   	
	{  
		Landlord result=landlordService.updateLandlord(landlord);
		if(result!=null) {
			return new ResponseEntity<Landlord>(result,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<Landlord>(HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}
	
	//Delete Landlord By Id
	@DeleteMapping("/landlord/delete/{landlordId}")
	public ResponseEntity<?> deleteLandlord(@PathVariable int landlordId) throws LandlordNotFoundException {
		Landlord result = landlordService.deleteLandlord(landlordId);
		if(result!=null)
			return new ResponseEntity<>("landlord deleted successfully",HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// View Landlord By Id
	@GetMapping("/landlord/view")
	public ResponseEntity<Landlord> viewLandlord(@PathVariable int landlordId) throws LandlordNotFoundException  {
		Landlord result=landlordService.viewLandlord(landlordId);
		if(result!=null)
		{
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	//View All Landlord

	@GetMapping("/view-landlord")
	public ResponseEntity<List<Landlord>> viewAllLandlord(){
		List<Landlord> result=landlordService.viewAllLandlord();
		if(result!=null)
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}




}