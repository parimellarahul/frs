package com.frs.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frs.demo.entity.User;
import com.frs.demo.exceptions.NoSuchUserException;
import com.frs.demo.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserController {
//	@Autowired
//	 IUserService iuserService;

	@Autowired
	UserService iuserService;

	@GetMapping("/get-all-users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> result = iuserService.getAlluser();
		if (result != null) {
			return new ResponseEntity<List<User>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/add-user")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User result = iuserService.addUser(user);
		if (result != null) {
			return new ResponseEntity<User>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-user-by-id/{userId}")
	public ResponseEntity<User> getUserById(@Valid @PathVariable("userId") int userId) throws NoSuchUserException {
		User result = iuserService.findUserById(userId);
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-user-by-userName/{userName}/{userId}")
	public ResponseEntity<?> updateUserById(@Valid @PathVariable String userName, @PathVariable int userId)
			throws NoSuchUserException {
		User result = iuserService.updateUserById(userName, userId);
		if (result != null)
			return new ResponseEntity<>(result, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("/delete-user/{userId}")
	public ResponseEntity<?> deleteUserByuserId(@Valid @PathVariable int userId) throws NoSuchUserException {
		boolean result = iuserService.deleteUserByuserId(userId);
		if (result)
			return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/update-password/{newpass}/{userId}")
	public ResponseEntity<User> updatePassword(@Valid @PathVariable String newpass, @PathVariable int userId)
			throws NoSuchUserException {
		User pass = iuserService.updatePassword(newpass, userId);
		if (pass != null) {
			return new ResponseEntity<>(pass, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
