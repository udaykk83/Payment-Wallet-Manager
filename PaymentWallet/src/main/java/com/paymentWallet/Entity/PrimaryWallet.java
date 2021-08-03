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
public class PrimaryWallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int accountNumber;
	private BigDecimal walletBalance;

	@OneToMany(mappedBy = "primaryWallet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PrimaryWalletTransaction> primaryWalletTransactionList;

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

	public List<PrimaryWalletTransaction> getPrimaryWalletTransactionList() {
		return primaryWalletTransactionList;
	}

	public void setPrimaryWalletTransactionList(List<PrimaryWalletTransaction> primaryWalletTransactionList) {
		this.primaryWalletTransactionList = primaryWalletTransactionList;
	}

	
	

}
