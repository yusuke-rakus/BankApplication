package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Bank;

@Repository
public class BankListRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Bank> BANK_ROW_MAPPER = 
			new BeanPropertyRowMapper<>(Bank.class);
	
	public List<Bank> findAll(){
		String sql = "SELECT * FROM bank_list ORDER BY id;";
		return template.query(sql, BANK_ROW_MAPPER);
	}

}
