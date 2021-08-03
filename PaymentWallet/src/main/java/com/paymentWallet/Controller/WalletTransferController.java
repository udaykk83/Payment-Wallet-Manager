package com.paymentWallet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.paymentWallet.Entity.PrimaryWallet;
import com.paymentWallet.Entity.SecondaryWallet;
import com.paymentWallet.Entity.User;
import com.paymentWallet.Service.TransactionService;
import com.paymentWallet.Service.UserService;

public class WalletTransferController {
	@Autowired
	TransactionService transactionService;
	@Autowired
	UserService userService;
	
	@PostMapping("/user/betweenWallets")
	public void betweenWallets(@RequestBody String from,String to,double amount,User user) throws Exception {
		User obj=userService.findByUsername(user.getUsername());
		PrimaryWallet primaryWallet=obj.getPrimaryWallet();
		SecondaryWallet secondaryWallet=obj.getSecondaryWallet();
		transactionService.transferBtwWallets(from,to,amount,primaryWallet,secondaryWallet);
	}

}
