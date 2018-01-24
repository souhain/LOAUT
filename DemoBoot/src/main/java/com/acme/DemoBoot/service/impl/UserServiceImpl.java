package com.acme.DemoBoot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.DemoBoot.modelo.User;
import com.acme.DemoBoot.repository.UserRepository;
import com.acme.DemoBoot.service.UserService;



// a esta clase hay que decorarla
//tu eres un servicio, tu implementas esa interface
//aqui se va a hacer uso del repository


@Service
public class UserServiceImpl implements UserService {
	@Autowired  // para ir a buscar al contenedor a alguien que implementa userRepository y lo inyecta
	private UserRepository userRepository;
	
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public User findById(long id) {
		return userRepository.findOne(id);
	}
	
	public User findByName(String name) {
		return userRepository.findByUsername(name);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public void deleteUserById(long id) {
		userRepository.delete(id);
	
	} 

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		userRepository.deleteAll();
	}
}



