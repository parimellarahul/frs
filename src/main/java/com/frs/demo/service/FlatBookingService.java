package com.frs.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frs.demo.entity.FlatBooking;
import com.frs.demo.exceptions.NoSuchFlatBookingException;

@Service
public interface FlatBookingService {
	public FlatBooking addFlatBooking(FlatBooking flat);

	public FlatBooking updateFlatBooking(FlatBooking flat);

	public boolean delete(FlatBooking bookingNo);

	public List<FlatBooking> getAllFlatBookings();

	public List<FlatBooking> viewAllflats();

	public List<FlatBooking> viewAllFlatBookings();

	public FlatBooking getFlatById(int bookingNo) throws NoSuchFlatBookingException;
}
