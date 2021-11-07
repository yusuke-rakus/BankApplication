package com.example.demo.form;

/**
 * ログイン時のフォームを受け取るクラス
 */
public class LoginForm {

	private String accountNumber;
	private String password;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginForm [accountNumber=" + accountNumber + ", password=" + password + "]";
	}

}
