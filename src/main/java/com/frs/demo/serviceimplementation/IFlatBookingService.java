package com.frs.demo.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frs.demo.entity.FlatBooking;
import com.frs.demo.exceptions.NoSuchFlatBookingException;
import com.frs.demo.repository.IFlatBookingRepository;
import com.frs.demo.service.FlatBookingService;




@Service
public  class IFlatBookingService implements FlatBookingService{

	@Autowired
	IFlatBookingRepository iflatbookingRepository;

	@Override
	public FlatBooking addFlatBooking(FlatBooking flat) {
		// TODO Auto-generated method stub
		return iflatbookingRepository.save(flat);
	}

	@Override
	public FlatBooking updateFlatBooking(FlatBooking flat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(FlatBooking bookingNo) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FlatBooking> getAllFlatBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlatBooking> viewAllflats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlatBooking> viewAllFlatBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlatBooking getFlatById(int bookingNo) throws NoSuchFlatBookingException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
