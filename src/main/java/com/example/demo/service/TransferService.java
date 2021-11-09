package com.example.demo.service;

import java.sql.Date;
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
	public void save(User withdrawalUser, Integer withdrawalAmount, 
			User depositUser, Integer depositAmount, Integer transferAmount) {
		LocalDate tradeDate = LocalDate.now();
		TransferColumn column = new TransferColumn(
				Date.valueOf(tradeDate), 
				transferAmount, // 取引金額
				withdrawalUser.getAccountNumber(), // 出金口座
				withdrawalAmount, // 出金口座取引後の残高
				depositUser.getAccountNumber(), // 入金口座
				depositAmount // 入金口座取引後の残高
		);
		repository.save(column);
	}

	public List<TransferColumn> findTransferList(String account) {
		return repository.findTransferList(account);
	}

}
