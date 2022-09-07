package com.frs.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frs.demo.entity.Flat;
import com.frs.demo.exceptions.FlatNotFoundException;
import com.frs.demo.exceptions.FlatNotPresentException;
import com.frs.demo.exceptions.FlatNotUpdatedException;
import com.frs.demo.exceptions.InvalidException;
import com.frs.demo.exceptions.NoFlatPresentException;
import com.frs.demo.service.FlatServices;

@RestController
@RequestMapping("/api")
public class Flatcontroller {
	@Autowired
	private FlatServices flatServices;

	@PostMapping("/flats")
	public ResponseEntity<String> addFlat(@RequestBody Flat flat) throws InvalidException {
		String list = flatServices.addFlat(flat);
		if (list.isEmpty()) {
			throw new InvalidException("No flat is added!");
		}
		return ResponseEntity.ok(list);
	}

	@PutMapping("/flats")
	public ResponseEntity<String> updateFlat(@RequestBody Flat flat) throws FlatNotUpdatedException {
		String list = flatServices.updateFlat(flat);
		if (list.isEmpty()) {
			throw new FlatNotUpdatedException("No flat is updated!");
		}
		return ResponseEntity.ok(list);
	}

	@DeleteMapping("/flats/{flatid}")
	private void deleteByflatid(@PathVariable int flatid) throws FlatNotFoundException {
		Flat flat = flatServices.findFlatById(flatid).get();
		if (flat==null) {
			throw new FlatNotFoundException("No flat found with the given id: " + flatid);
		}
		flatServices.deleteFlat(flatid);
	}

	@GetMapping("/flats")
	public ResponseEntity<List<Flat>> viewAllFlats() throws NoFlatPresentException {
		List<Flat> list = flatServices.getAllFlats();
		if (list.isEmpty()) {
			throw new NoFlatPresentException("There are no flats present in the database!");
		}
		return ResponseEntity.ok(list);
	}

	@SuppressWarnings("null")
	@GetMapping("/Flat/{id}")
	public ResponseEntity<Object> findFlatByflatid(@PathVariable int flatid) throws FlatNotFoundException {
		Flat flat = flatServices.findFlatById(flatid).get();
		if (flat!=null) {
			throw new FlatNotFoundException("No flat found with the given id: " + flatid);
		}
		return ResponseEntity.ok(flat);
	}

	@SuppressWarnings("null")
	@GetMapping("/Flat/{Cost}")
	public ResponseEntity<Object> findFlatByCost(@PathVariable float Cost) throws FlatNotPresentException {
		Flat flat = flatServices.findFlatByCost(Cost).get();
		if (flat!=null) {
			throw new FlatNotPresentException("No flat found with the given Cost: " + Cost);
		}
		return ResponseEntity.ok(flat);
	}
}
