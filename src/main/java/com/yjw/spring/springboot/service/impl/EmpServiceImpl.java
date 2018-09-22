package com.yjw.spring.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjw.spring.springboot.dao.entity.Emp;
import com.yjw.spring.springboot.dao.entity.EmpExample;
import com.yjw.spring.springboot.dao.mapper.EmpMapper;
import com.yjw.spring.springboot.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
	private EmpMapper empMapper;
	
	@Override
	public List<Emp> findAll() {
		// TODO Auto-generated method stub
		return empMapper.selectByExample(new EmpExample());
	}

}
