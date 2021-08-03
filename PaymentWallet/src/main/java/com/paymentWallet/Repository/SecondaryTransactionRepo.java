package com.paymentWallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentWallet.Entity.SecondaryWalletTransaction;

@Repository
public interface SecondaryTransactionRepo extends JpaRepository<SecondaryWalletTransaction, Long> {

}
