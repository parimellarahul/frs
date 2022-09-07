package com.frs.demo.service;

import java.util.List;

import com.frs.demo.entity.Landlord;
import com.frs.demo.exceptions.LandlordNotFoundException;


public interface LandlordService {
	public Landlord addLandlord(Landlord landlord);
	public Landlord updateLandlord(Landlord landlord);
	public Landlord deleteLandlord(int landlordId);
	public Landlord viewLandlord(int id) throws LandlordNotFoundException;
	public List<Landlord> viewAllLandlord();

}