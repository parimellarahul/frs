package com.frs.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.frs.demo.entity.User;
import com.frs.demo.exceptions.NoSuchUserException;

@Service
public interface UserService {

	public User addUser(User user);

	public User findUserById(int userId) throws NoSuchUserException;

	public User updateUser(User user);

	boolean deleteUserByuserName(String userName) throws NoSuchUserException;

	public User updatePassword(String newpass, int userId) throws NoSuchUserException;

	public User findUserByuserName(String userName);

	void removeUser(String userName) throws NoSuchUserException, Exception;

	List<User> getAlluser();

	public User updateUserById(@Valid String userName, int userId) throws NoSuchUserException;

	public boolean deleteUserByuserId(@Valid int userId) throws NoSuchUserException;

}
