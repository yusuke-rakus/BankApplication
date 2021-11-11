package com.example.demo.domain;

public class Bank {

	private String bankCode;
	private String bankName;
	private String bankColorCode;

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankColorCode() {
		return bankColorCode;
	}

	public void setBankColorCode(String bankColorCode) {
		this.bankColorCode = bankColorCode;
	}

	@Override
	public String toString() {
		return "Bank [bankCode=" + bankCode + ", bankName=" + bankName + ", bankColorCode=" + bankColorCode + "]";
	}

}
