package com.yjw.spring.springboot.service;

import java.util.List;

import com.yjw.spring.springboot.dao.entity.Emp;
import com.yjw.spring.springboot.dto.emp.EmpResult;

public interface EmpService {

	List<Emp> findAll();
	
	void findTableChangeCursor(EmpResult result);
}
