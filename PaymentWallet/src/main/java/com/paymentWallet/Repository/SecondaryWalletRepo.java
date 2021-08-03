package com.paymentWallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentWallet.Entity.SecondaryWallet;

@Repository
public interface SecondaryWalletRepo extends JpaRepository<SecondaryWallet, Long> {

	SecondaryWallet findByAccountNumber(int accountNumber);

}
