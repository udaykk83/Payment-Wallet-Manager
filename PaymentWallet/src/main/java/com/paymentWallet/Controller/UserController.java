package com.paymentWallet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentWallet.Entity.User;
import com.paymentWallet.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {

		User obj = new User();
		obj.setEmail(user.getEmail());
		obj.setFirstName(user.getFirstName());
		obj.setLastName(user.getLastName());
		obj.setUsername(user.getUsername());
		obj.setUserId(user.getUserId());
		userService.createWallet(user);
		return obj;
	}

	@GetMapping("/getuser")
	public List<User> getUser() {

		return userService.getAllDetails();
	}

//	@PostMapping("/createWallet")
//	public User createUserWallets(@RequestBody User user) {
//
//		User obj = userService.createWallet(user);
//		return obj;
//	}

}
