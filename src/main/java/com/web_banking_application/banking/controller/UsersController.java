package com.web_banking_application.banking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web_banking_application.banking.dto.UsersDto;
import com.web_banking_application.banking.service.UserService;
@CrossOrigin({"https://chipper-vacherin-299a05.netlify.app/"})
@RestController
@RequestMapping("/api/users")
public class UsersController {
	private UserService userService;
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

    @PostMapping("/register")
    @CrossOrigin({"https://chipper-vacherin-299a05.netlify.app/"})
    public ResponseEntity<?> registerUser(@RequestBody UsersDto userDto) {
        // You can add validations and checks here
        userService.registerUser(userDto);
        return ResponseEntity.ok("User registered successfully");
    }
	
	//Build Add user Rest API
	@PostMapping
	public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto userDto){
		UsersDto savedUser = userService.createUsers(userDto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	//Build get users Rest API
	@GetMapping("{id}")
	public ResponseEntity<UsersDto> getUsersByID(@PathVariable("id") Long UserID){
		UsersDto usersDto = userService.getUsersByID(UserID);
		return ResponseEntity.ok(usersDto);
	}
	
	//Build getAll Users Rest API
	@GetMapping 
	public ResponseEntity<List<UsersDto>> getAllUsers(){
		List<UsersDto> Users = userService.getAllUsers();
		return ResponseEntity.ok(Users);
	}
	
	//Build Update Users RestAPI
	@PutMapping("{id}")
	public ResponseEntity<UsersDto> updateUsers(@PathVariable("id") Long userId, @RequestBody UsersDto updatedUsers){
		UsersDto usersDto = userService.updateUser(userId, updatedUsers);
		return ResponseEntity.ok(usersDto);
	}
	
	//Build Delete User Rest API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
		userService.deleteUser(userId);
		return ResponseEntity.ok("User Deleted Successfully!");
	}
}