package com.felipefaggian.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipefaggian.workshopmongo.domain.User;
import com.felipefaggian.workshopmongo.repository.UserRepository;
import com.felipefaggian.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	/*
	 * public User findById(String id) { User user = repo.findOne(id); if(user ==
	 * null) { throw new ObjectNotFoundException("Objeto não encontrado"); } return
	 * user; }
	 */

	public User findById(String id) {
		Optional<User> user = repo.findById(id);

		User user1 = new User();

		user1.setId(user.get().getId());
		user1.setName(user.get().getName());
		user1.setEmail(user.get().getEmail());
		
		  if(user == null) { 
			  throw new ObjectNotFoundException("Objeto não encontrado"); }
		 
		return user1;
		}
	}

