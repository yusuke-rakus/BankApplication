package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Bank;

@Repository
public class BankListRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Bank> BANK_ROW_MAPPER = 
			new BeanPropertyRowMapper<>(Bank.class);
	
	/** 銀行の全件取得 */
	public List<Bank> findAll(){
		String sql = "SELECT * FROM bank_list ORDER BY id;";
		return template.query(sql, BANK_ROW_MAPPER);
	}
	
	/** 銀行名から銀行レコード取得 */
	public Bank findByBankName(String bankName) {
		String sql = "SELECT * FROM bank_list WHERE bank_name = :bankName;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("bankName", bankName);
		Bank bank = template.queryForObject(sql, param, BANK_ROW_MAPPER);
		return bank;
	}

}
