package com.example.demo.form;

public class TransferForm {

	private Integer id;
	private String bankName;
	private String acceptAccount;
	private Integer amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAcceptAccount() {
		return acceptAccount;
	}

	public void setAcceptAccount(String acceptAccount) {
		this.acceptAccount = acceptAccount;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransferForm [id=" + id + ", bankName=" + bankName + ", acceptAccount=" + acceptAccount + ", amount="
				+ amount + "]";
	}

}
