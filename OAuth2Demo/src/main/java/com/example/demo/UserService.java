package com.example.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	
	/* Test users */
	@PostConstruct
	public void createNewUsers() {
		User user1 = new User();
		user1.setUsername("Mahesh");
		user1.setPassword("mahesh");
		
		user1.setRoles(Arrays.asList(new UserRole("ADMIN")));
		
		
		CrmUserDetails crmUserDetails = new CrmUserDetails(user1);
		repository.save(user1);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(
					user.getUsername(),
					user.getPassword(),
					(Collection<? extends GrantedAuthority>) Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))
				);
	}
	public List<User> findAllUsers() {
		
		return (List<User>) repository.findAll();
	}
	
	public User findById(long id) {

		return repository.findById(id);
	}
	public void updateUser(User currentUser) {

		repository.save(currentUser);
	}
	public void deleteUserById(long id) {
		
		repository.deleteUserById(id);
		}
	public void saveUser(User user) {
		
		repository.save(user);
	}
	public boolean isUserExist(User user) {
	
		return repository.existsById(user.getId());
	}
	
}
