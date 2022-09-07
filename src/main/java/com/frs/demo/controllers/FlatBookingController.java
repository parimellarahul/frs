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

import com.frs.demo.entity.FlatBooking;
import com.frs.demo.exceptions.NoSuchFlatBookingException;
import com.frs.demo.service.FlatBookingService;




@RestController
@RequestMapping("/api")
public class FlatBookingController {
	

	@Autowired
	public FlatBookingService iflatbookingService; 
	
	
	@GetMapping("/get-all-flats")
	public ResponseEntity<List<FlatBooking>> viewAllFlatBooking(){
		List<FlatBooking> result =iflatbookingService.viewAllFlatBookings();
		if(result !=null) {
			return new ResponseEntity<List<FlatBooking>>(result,HttpStatus.OK);
		}
		else { 
			return new ResponseEntity<List<FlatBooking>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	@PostMapping("/add-flats")
	public ResponseEntity<FlatBooking> addFlatBooking(@RequestBody FlatBooking flat){
		FlatBooking result =iflatbookingService.addFlatBooking(flat);
		if(result != null) {
			return new ResponseEntity<FlatBooking>(result,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<FlatBooking>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/get-flats-by-id/{flatid}")
	public ResponseEntity<?> getFlatById(@PathVariable("flatid") int bookingNo)throws NoSuchFlatBookingException{
		
		FlatBooking result = iflatbookingService.getFlatById(bookingNo);
		if(result != null) {  
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No flats Available Please Add flats" ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/update-flats")
	public ResponseEntity<FlatBooking> updateFlatBooking(@RequestBody FlatBooking flat){
		FlatBooking result = iflatbookingService.updateFlatBooking(flat);
		if(result !=null) {
			return new ResponseEntity<FlatBooking>(result,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<FlatBooking>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@DeleteMapping("/flat/{bookingNo}")  
	private void deleteFlatBooking(@PathVariable("bookingNo") FlatBooking bookingNo)   
	{  
	iflatbookingService.delete(bookingNo);  
	} 
	
	


	
}