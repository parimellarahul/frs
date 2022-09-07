package com.frs.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frs.demo.entity.FlatBooking;


@Repository
public interface IFlatBookingRepository extends JpaRepository<FlatBooking,Integer>{

}