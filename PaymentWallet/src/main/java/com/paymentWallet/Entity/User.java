package com.paymentWallet.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false, updatable = false)
    private Long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private String phone;
    
    @OneToOne
    private PrimaryWallet primaryWallet;

    @OneToOne
    private SecondaryWallet secondaryWallet;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public PrimaryWallet getPrimaryWallet() {
		return primaryWallet;
	}

	public void setPrimaryWallet(PrimaryWallet primaryWallet) {
		this.primaryWallet = primaryWallet;
	}

	public SecondaryWallet getSecondaryWallet() {
		return secondaryWallet;
	}

	public void setSecondaryWallet(SecondaryWallet secondaryWallet) {
		this.secondaryWallet = secondaryWallet;
	}
}
