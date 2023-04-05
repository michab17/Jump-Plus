package com.dollarsbank.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.dollarsbank.utility.ConsoleColors;

public class Transaction {
	private String transactionType;
	private String transactionDescription;
	private Timestamp transactionTimestamp;
	private Integer accountId;



	public Transaction(String transactionType, String transactionDescription, Timestamp transactionTimestamp, Integer accountId) {
		super();
		this.transactionType = transactionType;
		this.transactionDescription = transactionDescription;
		this.transactionTimestamp = transactionTimestamp;
		this.accountId = accountId;
	}

	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "Transaction type: " + transactionType + "\n Transaction description: " + transactionDescription + "\n Time of transaction: " + transactionTimestamp;
	}
	
}
