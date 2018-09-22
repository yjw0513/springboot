package com.yjw.spring.springboot.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.yjw.spring.springboot.dto.emp.EmpResult;

public interface EmpProcedureMapper extends EmpMapper{
	
	void findTableChangeCursor(@Param("result")EmpResult result);
}