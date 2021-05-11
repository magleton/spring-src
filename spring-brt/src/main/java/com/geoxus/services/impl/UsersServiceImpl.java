package com.geoxus.services.impl;

import com.geoxus.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insert() {
		String sql = "insert into users(`user-name` , `password`,`age`) values (? , ? , ?)";
		int count = jdbcTemplate.update(sql, "britton01", "123445", 32);
		//throw new RuntimeException("自定义异常");
		return count;
	}
}
