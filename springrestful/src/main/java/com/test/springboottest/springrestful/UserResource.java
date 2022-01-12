package com.test.springboottest.springrestful;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	UserResourceService userService;
	
	@GetMapping(path = "/users")
	public List<User> retrieveUsers() {
		
				
		return userService.retrieveUsers();
	}
	
	
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable int id) throws Exception {
		
				if(userService.retrieveUser(id) == null) {
					
					throw new Exception(); // UserNotFoundException("id"+id);
					
				}
				
		return userService.retrieveUser(id);
	}
	
	@PostMapping(path = "/user")
	public void saveUser(@Valid @RequestBody User user) {
		
		
		User savedUser = userService.saveUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{Id}").buildAndExpand(savedUser.getId()).toUri();
		
		ResponseEntity.created(uri).build();
		
		
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User deletedUser = userService.deleteUser(id);
		
		if(deletedUser == null) {
			
			throw new UserNotFoundException(""+id);
			
		}
		
	}

}
