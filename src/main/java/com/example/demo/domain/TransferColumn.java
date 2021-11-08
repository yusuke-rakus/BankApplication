package com.example.demo.domain;

import java.sql.Date;

public class TransferColumn {

	private Integer id;
	private Date tradeDate;
	private Integer amount;
	private String withdrawalAccount;
	private String depositAccount;
	
	public TransferColumn(Date tradeDate, Integer amount, String withdrawalAccount, String depositAccount) {
		super();
		this.tradeDate = tradeDate;
		this.amount = amount;
		this.withdrawalAccount = withdrawalAccount;
		this.depositAccount = depositAccount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getWithdrawalAccount() {
		return withdrawalAccount;
	}

	public void setWithdrawalAccount(String withdrawalAccount) {
		this.withdrawalAccount = withdrawalAccount;
	}

	public String getDepositAccount() {
		return depositAccount;
	}

	public void setDepositAccount(String depositAccount) {
		this.depositAccount = depositAccount;
	}

	@Override
	public String toString() {
		return "TransferTable [id=" + id + ", tradeDate=" + tradeDate + ", amount=" + amount + ", withdrawalAccount="
				+ withdrawalAccount + ", depositAccount=" + depositAccount + "]";
	}

}
