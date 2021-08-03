package com.paymentWallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentWallet.Entity.PrimaryWallet;
import com.paymentWallet.Entity.SecondaryWallet;

@Repository
public interface PrimaryWalletRepo extends JpaRepository<PrimaryWallet, Long> {

	PrimaryWallet findByAccountNumber(int accountNumber);

}
