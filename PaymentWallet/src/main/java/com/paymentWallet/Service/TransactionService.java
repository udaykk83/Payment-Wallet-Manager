package com.paymentWallet.Service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentWallet.Entity.PrimaryWallet;
import com.paymentWallet.Entity.PrimaryWalletTransaction;
import com.paymentWallet.Entity.SecondaryWallet;
import com.paymentWallet.Entity.SecondaryWalletTransaction;
import com.paymentWallet.Repository.PrimaryTransactionRepo;
import com.paymentWallet.Repository.PrimaryWalletRepo;
import com.paymentWallet.Repository.SecondaryTransactionRepo;
import com.paymentWallet.Repository.SecondaryWalletRepo;

@Service
public class TransactionService {

	@Autowired
	UserService userService; 
	@Autowired
	PrimaryWalletRepo primaryWalletRepo;
	@Autowired
	SecondaryWalletRepo secondaryWalletRepo;
	@Autowired
	PrimaryTransactionRepo primaryTransactionRepo;
	@Autowired
	SecondaryTransactionRepo secondaryTransactionRepo;
	public void savePrimaryWalletTransaction(PrimaryWalletTransaction primaryWalletTransaction) {
		// TODO Auto-generated method stub
		primaryTransactionRepo.save(primaryWalletTransaction);		
	}
	public void saveSecondaryWalletTransaction(SecondaryWalletTransaction secondaryWalletTransaction) {
		// TODO Auto-generated method stub
		secondaryTransactionRepo.save(secondaryWalletTransaction);
	}
	public void saveEncashPrimaryWalletTransaction(PrimaryWalletTransaction primaryWalletTransaction) {
		// TODO Auto-generated method stub
		primaryTransactionRepo.save(primaryWalletTransaction);
	}
	public void saveEncashSecondaryWalletTransaction(SecondaryWalletTransaction secondaryWalletTransaction) {
		// TODO Auto-generated method stub
		secondaryTransactionRepo.save(secondaryWalletTransaction);
	}

	public void transferBtwWallets(String from, String to, double amount, PrimaryWallet primaryWallet,
			SecondaryWallet secondaryWallet) throws Exception {
		// TODO Auto-generated method stub
		 if (from.equalsIgnoreCase("Primary") && to.equalsIgnoreCase("Savings")) {
	            primaryWallet.setWalletBalance(primaryWallet.getWalletBalance().subtract(new BigDecimal(amount)));
	            secondaryWallet.setWalletBalance(secondaryWallet.getWalletBalance().add(new BigDecimal(amount)));
	            primaryWalletRepo.save(primaryWallet);
	            secondaryWalletRepo.save(secondaryWallet);

	            Date date = new Date();

	            PrimaryWalletTransaction primaryWalletTransaction = new PrimaryWalletTransaction(date, "Between account transfer from " + from + " to " + to, "Account", "Finished", amount, primaryWallet.getWalletBalance(), primaryWallet);
	            primaryTransactionRepo.save(primaryWalletTransaction);
	        } else if (from.equalsIgnoreCase("Savings") && to.equalsIgnoreCase("Primary")) {
	        	primaryWallet.setWalletBalance(primaryWallet.getWalletBalance().add(new BigDecimal(amount)));
	        	secondaryWallet.setWalletBalance(secondaryWallet.getWalletBalance().subtract(new BigDecimal(amount)));
	        	primaryWalletRepo.save(primaryWallet);
	        	secondaryWalletRepo.save(secondaryWallet);

	            Date date = new Date();

	            SecondaryWalletTransaction secondaryWalletTransaction = new SecondaryWalletTransaction(date, "Between account transfer from " + from + " to " + to, "Transfer", "Finished", amount, secondaryWallet.getWalletBalance(), secondaryWallet);
	            secondaryTransactionRepo.save(secondaryWalletTransaction);
	        } else {
	            throw new Exception("Invalid Transfer");
	        }
	}
	
	
	


}
