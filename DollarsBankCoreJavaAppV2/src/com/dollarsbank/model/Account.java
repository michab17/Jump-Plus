package com.dollarsbank.model;

import java.util.ArrayList;

import com.dollarsbank.utility.ConsoleColors;

public class Account {
	
	private String name;
	
	private String username;
	
	private String pin;
	
	private Double availableFunds;
	
	public ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	public Account(String name, String username, String pin, Double availableFunds) {
		super();
		this.name = name;
		this.username = username;
		this.pin = pin;
		this.availableFunds = availableFunds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Double getAvailableFunds() {
		return availableFunds;
	}

	public void setAvailableFunds(Double available_funds) {
		this.availableFunds = available_funds;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	@Override
	public String toString() {
		return ConsoleColors.WHITE + "Name: " + name + "\nUser Id: " + username + "\nPin: " + pin + "\nAvailable Funds: " + availableFunds;
	}

}
