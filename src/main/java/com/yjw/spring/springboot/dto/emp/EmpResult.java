package com.yjw.spring.springboot.dto.emp;

import java.util.List;

import com.yjw.spring.springboot.dao.entity.Emp;

public class EmpResult {

	private List<Emp> empList;

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
}
