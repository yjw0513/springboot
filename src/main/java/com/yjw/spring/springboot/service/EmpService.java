package com.yjw.spring.springboot.service;

import java.util.List;

import com.yjw.spring.springboot.dao.entity.Emp;

public interface EmpService {

	List<Emp> findAll();
}
