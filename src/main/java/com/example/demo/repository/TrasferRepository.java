package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.TransferColumn;

@Repository
public class TrasferRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<TransferColumn> TRANSFER_ROW_MAPPER = 
			new BeanPropertyRowMapper<>(TransferColumn.class);
	
	/** 新規取引をテーブルに保存 */
	public void save(TransferColumn column) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(column);
		String sql = "INSERT INTO transaction_list"
				+ "(trade_date, amount, withdrawal_account, withdrawal_amount, deposit_account, deposit_amount) "
				+ "VALUES(:tradeDate, :amount, :withdrawalAccount, :withdrawalAmount, :depositAccount, :depositAmount);";
		template.update(sql, param);
	}
	
	/** 口座番号を指定して取引履歴を取得 */
	public List<TransferColumn> findTransferList(String account){
		String sql = "SELECT * FROM transaction_list"
				+ " WHERE withdrawal_account=:withdrawalAccount"
				+ " OR deposit_account=:depositAccount"
				+ " ORDER BY trade_date;";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("withdrawalAccount", account).addValue("depositAccount", account);
		List<TransferColumn> transferColumns = template.query(sql, param, TRANSFER_ROW_MAPPER);
		return transferColumns;
	}
	
}
