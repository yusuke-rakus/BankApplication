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

import com.example.demo.domain.User;

/**
 * DBからユーザー情報を取得するリポジトリ
 * @author yusukematsumoto
 */
@Repository
public class UserRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<User> USER_ROW_MAPPER =
			new BeanPropertyRowMapper<>(User.class);
	
	/**
	 * 口座番号, パスワードから一致するアカウントがあれば
	 * インスタンスを返却する
	 */
	public User findByAccountAndPassword(String accountNumber, String password) {
		String sql = "SELECT * FROM user_info "
				+ "WHERE account_number=:accountNumber AND password=:password;";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("accountNumber", accountNumber).addValue("password", password);
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		if(userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}
	
	public User findByBankNameAndAccount(String bankName, String accountNumber) {
		String sql = "SELECT * FROM user_info "
				+ "WHERE bank_name=:bankName AND account_number=:accountNumber;";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("bankName", bankName).addValue("accountNumber", accountNumber);
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		if(userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}
	
	public User findById(Integer id) {
		String sql = "SELECT * from user_info WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		User user = template.queryForObject(sql, param, USER_ROW_MAPPER);
		return user;
	}
	
	public void insert(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		if(user.getId() == null) {
			String sql = "INSERT INTO user_info(last_name, first_name, gender, age"
					+ ", address, bank_name, account_number, amount, password) "
					+ "VALUES(:lastName, :firstName, :gender, :age, :address"
					+ ", :bankName, :accountNumber, :amount, :password);";
			template.update(sql, param);
		} else {
			String sql = "UPDATE user_info "
					+ "SET last_name=:lastName, first_name=:firstName, gender=:gender, "
					+ "age=:age, address=:address, bank_name=:bankName, "
					+ "account_number=:accountNumber, amount=:amount, password=:password "
					+ "WHERE id=:id;";
			template.update(sql, param);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
