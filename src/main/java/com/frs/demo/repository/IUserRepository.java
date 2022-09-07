package com.frs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frs.demo.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {



}