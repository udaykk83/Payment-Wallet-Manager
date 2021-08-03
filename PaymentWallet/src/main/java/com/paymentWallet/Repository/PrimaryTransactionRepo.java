package com.paymentWallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentWallet.Entity.PrimaryWalletTransaction;
import com.paymentWallet.Entity.SecondaryWalletTransaction;

@Repository
public interface PrimaryTransactionRepo  extends JpaRepository<PrimaryWalletTransaction, Long>{

	void save(SecondaryWalletTransaction secondaryWalletTransaction);



}
