package com.example.demo.form;

public class NewAccountForm {
	private String lastName;
	private String firstName;
	private String gender;
	private Integer age;
	private String address;
	private String bankName;
	private Integer amount;
	private String password;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "NewAccountForm [lastName=" + lastName + ", firstName=" + firstName + ", gender=" + gender + ", age="
				+ age + ", address=" + address + ", bankName=" + bankName + ", amount=" + amount + ", password="
				+ password + "]";
	}
}
