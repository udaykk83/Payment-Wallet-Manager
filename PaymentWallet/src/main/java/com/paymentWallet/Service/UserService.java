package com.paymentWallet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentWallet.Entity.User;
import com.paymentWallet.Repository.PrimaryWalletRepo;
import com.paymentWallet.Repository.SecondaryWalletRepo;
import com.paymentWallet.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PrimaryWalletRepo primaryWalletRepo;
	@Autowired
	SecondaryWalletRepo secondaryWalletRepo;	
	@Autowired
	WalletService walletService;
	
	
	public User save(User obj) {
		
		return userRepository.save(obj);
	}


	public User createWallet(User user) {
		// TODO Auto-generated method stub
		User temp=userRepository.findByUsername(user.getUsername());
		user.setPrimaryWallet(walletService.createPrimaryWallet());
		user.setSecondaryWallet(walletService.createSecondaryWallet());
		temp=userRepository.save(user);
		return temp;
	}


	public List<User> getAllDetails() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}



}
