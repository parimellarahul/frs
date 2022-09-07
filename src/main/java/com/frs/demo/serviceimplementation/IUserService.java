package com.frs.demo.serviceimplementation;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frs.demo.entity.User;
import com.frs.demo.exceptions.NoSuchUserException;
import com.frs.demo.repository.IUserRepository;
import com.frs.demo.service.UserService;

@Service
public class IUserService implements UserService {
	@Autowired
	IUserRepository iuserRepository;

	@Override
	public List<User> getAlluser() {
		// TODO Auto-generated method stub
		return iuserRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return iuserRepository.save(user);
	}

	@Override
	public User findUserById(int userId) throws NoSuchUserException {
		try {
			User user = iuserRepository.findById(userId).get();
			if (user != null) {
				return user;
			}
		} catch (NoSuchElementException e) {
			throw new NoSuchUserException("User With User Id " + userId + " Not Found !!!");
		}
		return null;
	}

//	@Override
//	public User updateUser(User user) {
//		return iuserRepository.save(user);
//	}
	
	
	@Override
	public User updateUserById(String userName, int userId) throws NoSuchUserException {
		// TODO Auto-generated method stub
		User user = findUserById(userId);
		user.setUserName(userName);
		return iuserRepository.save(user);
	}

//	@Override
//	public boolean deleteUserByuserName(String userName) throws NoSuchUserException {
//		User user = findUserByuserName(userName);
//		iuserRepository.delete(user);
//		return true;
//	}
	
	@Override
	public boolean deleteUserByuserId(int userId) throws NoSuchUserException {
		User user = findUserById(userId);
		iuserRepository.delete(user);
		return true;
	}

	@Override
	public User updatePassword(String newpass,int userId) throws NoSuchUserException {
		// TODO Auto-generated method stub
		User user=findUserById(userId);
		user.setPassword(newpass);
		return iuserRepository.save(user);
	}

	@Override
	public User findUserByuserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(String userName) throws NoSuchUserException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUserByuserName(String userName) throws NoSuchUserException {
		// TODO Auto-generated method stub
		return false;
	}

}
