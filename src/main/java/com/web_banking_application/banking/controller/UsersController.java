package com.web_banking_application.banking.controller;

import java.util.List;
import java.util.Map;

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
@CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app"})
@RestController
@RequestMapping("/api/users")
public class UsersController {
	private UserService userService;
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

    @PostMapping("/register")
    @CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app/"})
    public ResponseEntity<?> registerUser(@RequestBody UsersDto userDto) {
        // You can add validations and checks here
        UsersDto registeredUser = userService.registerUser(userDto);
    return ResponseEntity.ok(Map.of("message", "User registered successfully", "userId", registeredUser.getuserId()));
    }
	
	//Build Add user Rest API
	@PostMapping
	@CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app/"})
	public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto userDto){
		UsersDto savedUser = userService.createUsers(userDto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	//Build get users Rest API
	@GetMapping("{id}")
	@CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app/"})
	public ResponseEntity<UsersDto> getUsersByID(@PathVariable("id") Long UserID){
		UsersDto usersDto = userService.getUsersByID(UserID);
		return ResponseEntity.ok(usersDto);
	}
	
	//Build getAll Users Rest API
	@GetMapping 
	@CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app/"})
	public ResponseEntity<List<UsersDto>> getAllUsers(){
		List<UsersDto> Users = userService.getAllUsers();
		return ResponseEntity.ok(Users);
	}
	
	//Build Update Users RestAPI
	@PutMapping("{id}")
	@CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app/"})
	public ResponseEntity<UsersDto> updateUsers(@PathVariable("id") Long userId, @RequestBody UsersDto updatedUsers){
		UsersDto usersDto = userService.updateUser(userId, updatedUsers);
		return ResponseEntity.ok(usersDto);
	}
	
	//Build Delete User Rest API
	@DeleteMapping("{id}")
	@CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app/"})
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
		userService.deleteUser(userId);
		return ResponseEntity.ok("User Deleted Successfully!");
	}
}