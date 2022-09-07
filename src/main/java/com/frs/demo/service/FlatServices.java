package com.frs.demo.service;

import java.util.List;
import java.util.Optional;

import com.frs.demo.entity.Flat;

public interface FlatServices {

	String addFlat(Flat flat);

	String updateFlat(Flat flat);

	Optional<Flat> findFlatById(int flatid);

	void deleteFlat(int flatid);

	List<Flat> getAllFlats();

	Optional<Flat> findFlatByCost(float cost);

}
