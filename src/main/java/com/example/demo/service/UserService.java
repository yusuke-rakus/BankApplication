package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User findByAccountAndPassword(String accountNumber, String password) {
		return repository.findByAccountAndPassword(accountNumber, password);
	}
	
	/** 口座番号がなければ番号を作成しuserへセット */
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

}
