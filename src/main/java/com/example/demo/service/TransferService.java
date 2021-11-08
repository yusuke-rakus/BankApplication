package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.TransferColumn;
import com.example.demo.domain.User;
import com.example.demo.repository.TrasferRepository;

@Service
@Transactional
public class TransferService {
	
	@Autowired
	private TrasferRepository repository;
	
	/** Controllerから出金口座、入金口座、取引金額を取得しtransaction_listへ格納 */
	public void save(User withdrawalUser, User depositUser, Integer transferAmount) {
		LocalDate tradeDate = LocalDate.now();
		TransferColumn column = new TransferColumn(Date.valueOf(tradeDate), 
				transferAmount, withdrawalUser.getAccountNumber(), 
				depositUser.getAccountNumber());
		repository.save(column);
	}
	
	public List<TransferColumn> findTransferList(String account){
		return repository.findTransferList(account);
	}
	
}
