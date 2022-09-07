package com.frs.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.frs.demo.entity.Flat;

public interface FlatRepository extends CrudRepository<Flat, Integer> {

	Optional<Flat> findByCost(float cost);

}