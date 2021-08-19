package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsername(String username);
	public User findById(long id);
	public User save(User user);
	public void deleteUserById(long id);
	public Iterable<User> findAll();
	public boolean existsById(long id);
}
