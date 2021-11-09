package com.example.demo.domain;

import java.sql.Date;

public class TransferColumn {

	private Integer id;
	private Date tradeDate;
	private Integer amount;
	private String withdrawalAccount;
	private Integer withdrawalAmount;
	private String depositAccount;
	private Integer depositAmount;

	public TransferColumn() {
	}

	public TransferColumn(Date tradeDate, Integer amount, String withdrawalAccount, Integer withdrawalAmount,
			String depositAccount, Integer depositAmount) {
		this.tradeDate = tradeDate;
		this.amount = amount;
		this.withdrawalAccount = withdrawalAccount;
		this.withdrawalAmount = withdrawalAmount;
		this.depositAccount = depositAccount;
		this.depositAmount = depositAmount;
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

	public Integer getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(Integer withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public String getDepositAccount() {
		return depositAccount;
	}

	public void setDepositAccount(String depositAccount) {
		this.depositAccount = depositAccount;
	}

	public Integer getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Integer depositAmount) {
		this.depositAmount = depositAmount;
	}

	@Override
	public String toString() {
		return "TransferColumn [id=" + id + ", tradeDate=" + tradeDate + ", amount=" + amount + ", withdrawalAccount="
				+ withdrawalAccount + ", withdrawalAmount=" + withdrawalAmount + ", depositAccount=" + depositAccount
				+ ", depositAmount=" + depositAmount + "]";
	}

}
