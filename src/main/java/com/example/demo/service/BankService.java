package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Bank;
import com.example.demo.repository.BankListRepository;

@Service
public class BankService {
	
	@Autowired
	private BankListRepository repository;
	
	public List<Bank> findAll(){
		return repository.findAll();
	}

}
