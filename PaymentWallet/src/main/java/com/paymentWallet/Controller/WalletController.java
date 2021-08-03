package com.paymentWallet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentWallet.Entity.PrimaryWallet;
import com.paymentWallet.Entity.User;
import com.paymentWallet.Service.UserService;
import com.paymentWallet.Service.WalletService;

@RestController
@RequestMapping("/user")
public class WalletController {
	
	@Autowired
	UserService userService;
	@Autowired
	WalletService walletService;
	
	
	@PostMapping("/deposit")
	public void deposit(@RequestBody double amount,String walletType,User user) {		
		walletService.deposit(walletType,amount,user);			
	}
	@PostMapping("/encash")
	public void encash(@RequestBody double amount,String walletType,User user) {		
		walletService.encash(walletType,amount,user);			
	}

}
