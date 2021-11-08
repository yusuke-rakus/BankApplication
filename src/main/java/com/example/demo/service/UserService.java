package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repository;

	/** 口座番号, パスワードからユーザーを取得 */
	public User findByAccountAndPassword(String accountNumber, String password) {
		return repository.findByAccountAndPassword(accountNumber, password);
	}
	/** 銀行名, 口座番号からユーザーを取得 */
	public User findByBankNameAndAccount(String bankName, String accountNumber) {
		return repository.findByBankNameAndAccount(bankName, accountNumber);
	}
	/** idからユーザーを取得 */
	public User findById(Integer id) {
		return repository.findById(id);
	}
	
	/** 新規口座開設
	 * 口座番号がなければ番号を作成しuserへセット 
	 * */
	public void insert(User user) {
		if(user.getAccountNumber() == null) {
			StringBuilder account = new StringBuilder();
			for (int i = 0; i < 7; i++) {
				account.insert(i, (int) (Math.random() * 10));
			}
			user.setAccountNumber(account.toString());
		}
		repository.insert(user);
	}

	
	/**
	 * 出金処理
	 * @param user 出金するアカウント
	 * @param amount 出金金額
	 */
	public void withdrawal(User user, Integer amount) {
		user.setAmount(user.getAmount() - amount);
		repository.insert(user);
	}
	/**
	 * 入金処理
	 * @param user 入金するアカウント
	 * @param amount 入金金額
	 */
	public void deposit(User user, Integer amount) {
		user.setAmount(user.getAmount() + amount);
		repository.insert(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
