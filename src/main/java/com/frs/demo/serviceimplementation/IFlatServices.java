package com.frs.demo.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frs.demo.entity.Flat;
import com.frs.demo.repository.FlatRepository;
import com.frs.demo.service.FlatServices;

@Service
public class IFlatServices implements FlatServices {
	@Autowired
	FlatRepository flatRepository;

	public String addFlat(Flat flat) {
		String message="Flat is added successfully";
		Flat f=flatRepository.save(flat);
		if(f==null)
		{
			return "flat is not added";
		}
		return message;
	}

	public String updateFlat(Flat flat) {
		String message="Flat is updated successfully";
		Flat f=flatRepository.save(flat);
		if(f==null) {
			return "flat is not updated";
		}
		return message;
	}

	public void deleteFlat(int flatid) {
		flatRepository.deleteById(flatid);
	}

	public List<Flat> getAllFlats() {
		 return (List<Flat>) flatRepository.findAll();
	}
	
	public Optional<Flat> findFlatByCost(float Cost){
		return flatRepository.findByCost(Cost);
	}

	public Optional<Flat> findFlatById(int flatid) {
		return flatRepository.findById(flatid);
	}
}