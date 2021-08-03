package com.paymentWallet.Service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentWallet.Entity.PrimaryWallet;
import com.paymentWallet.Entity.PrimaryWalletTransaction;
import com.paymentWallet.Entity.SecondaryWallet;
import com.paymentWallet.Entity.SecondaryWalletTransaction;
import com.paymentWallet.Entity.User;
import com.paymentWallet.Repository.PrimaryWalletRepo;
import com.paymentWallet.Repository.SecondaryWalletRepo;

@Service
public class WalletService {

	private int nextAccountNumber = 6558945;

	private int accountGen() {
		return ++nextAccountNumber;
	}

	@Autowired
	UserService userService;
	@Autowired
	PrimaryWalletRepo primaryWalletRepo;
	@Autowired
	SecondaryWalletRepo secondaryWalletRepo;
	@Autowired
	TransactionService transactionService;

	public PrimaryWallet createPrimaryWallet() {
		PrimaryWallet primaryWallet = new PrimaryWallet();
		primaryWallet.setWalletBalance(new BigDecimal(0.0));
		primaryWallet.setAccountNumber(accountGen());

		primaryWalletRepo.save(primaryWallet);

		return primaryWalletRepo.findByAccountNumber(primaryWallet.getAccountNumber());
	}

	public SecondaryWallet createSecondaryWallet() {
		SecondaryWallet secondaryWallet = new SecondaryWallet();
		secondaryWallet.setWalletBalance(new BigDecimal(0.0));
		secondaryWallet.setAccountNumber(accountGen());

		secondaryWalletRepo.save(secondaryWallet);

		return secondaryWalletRepo.findByAccountNumber(secondaryWallet.getAccountNumber());
	}

	public void deposit(String walletType, double amount, User user) {
		// User temp=userService.findByUsername(user.getUsername());

		if (walletType.equalsIgnoreCase("Primary")) {
			PrimaryWallet primaryWallet = user.getPrimaryWallet();
			primaryWallet.setWalletBalance(primaryWallet.getWalletBalance().add(new BigDecimal(amount)));
			primaryWalletRepo.save(primaryWallet);
			Date date = new Date();
			PrimaryWalletTransaction primaryWalletTransaction = new PrimaryWalletTransaction(date,
					"Deposit to Primary Wallet", "Account", "Finished", amount, primaryWallet.getWalletBalance(),
					primaryWallet);
			transactionService.savePrimaryWalletTransaction(primaryWalletTransaction);
		} else if (walletType.equalsIgnoreCase("Secondary")) {
			SecondaryWallet secondaryWallet = user.getSecondaryWallet();
			secondaryWallet.setWalletBalance(secondaryWallet.getWalletBalance().add(new BigDecimal(amount)));
			secondaryWalletRepo.save(secondaryWallet);
			Date date = new Date();
			SecondaryWalletTransaction secondaryWalletTransaction = new SecondaryWalletTransaction(date,
					"Deposit to Secondary Wallet", "Account", "Finished", amount, secondaryWallet.getWalletBalance(),
					secondaryWallet);
			transactionService.saveSecondaryWalletTransaction(secondaryWalletTransaction);
		}
	}

	public void encash(String walletType, double amount, User user) {
		// TODO Auto-generated method stub
		if (walletType.equalsIgnoreCase("Primary")) {
			PrimaryWallet primaryWallet = user.getPrimaryWallet();
			primaryWallet.setWalletBalance(primaryWallet.getWalletBalance().subtract(new BigDecimal(amount)));
			primaryWalletRepo.save(primaryWallet);
			Date date = new Date();
			PrimaryWalletTransaction primaryWalletTransaction = new PrimaryWalletTransaction(date,
					"Deposit to Primary Wallet", "Account", "Finished", amount, primaryWallet.getWalletBalance(),
					primaryWallet);
			transactionService.saveEncashPrimaryWalletTransaction(primaryWalletTransaction);
		} else if (walletType.equalsIgnoreCase("Secondary")) {
			SecondaryWallet secondaryWallet = user.getSecondaryWallet();
			secondaryWallet.setWalletBalance(secondaryWallet.getWalletBalance().subtract(new BigDecimal(amount)));
			secondaryWalletRepo.save(secondaryWallet);
			Date date = new Date();
			SecondaryWalletTransaction secondaryWalletTransaction = new SecondaryWalletTransaction(date,
					"Deposit to Secondary Wallet", "Account", "Finished", amount, secondaryWallet.getWalletBalance(),
					secondaryWallet);
			transactionService.saveEncashSecondaryWalletTransaction(secondaryWalletTransaction);
		}
	}

}
