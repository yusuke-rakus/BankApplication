package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class NewAccountForm {
	@Length(min=1, max=10, message="*1文字以上10文字以内で入力してください")
	private String lastName;
	@Length(min=1, max=10, message="*1文字以上10文字以内で入力してください")
	private String firstName;
	@NotNull(message = "*選択は必須です")
	private String gender;
	@NotNull(message = "*選択は必須です")
	private Integer age;
	@NotBlank(message = "*入力は必須です")
	private String address;
	@NotBlank(message = "*選択は必須です")
	private String bankName;
	@NotNull(message = "*入力は必須です")
	private Integer amount;
	@Length(min=5, message = "*5文字以上に設定してください")
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
