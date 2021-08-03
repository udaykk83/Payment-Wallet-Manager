package com.paymentWallet.Entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SecondaryWallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int accountNumber;
	private BigDecimal walletBalance;

	@OneToMany(mappedBy = "secondaryWallet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SecondaryWalletTransaction> secondaryWalletTransactionList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(BigDecimal walletBalance) {
		this.walletBalance = walletBalance;
	}

	public List<SecondaryWalletTransaction> getSecondaryWalletTransactionList() {
		return secondaryWalletTransactionList;
	}

	public void setSecondaryWalletTransactionList(List<SecondaryWalletTransaction> secondaryWalletTransactionList) {
		this.secondaryWalletTransactionList = secondaryWalletTransactionList;
	}

	
}
