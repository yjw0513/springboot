package com.yjw.spring.springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjw.spring.springboot.dao.entity.Emp;
import com.yjw.spring.springboot.dto.Result;
import com.yjw.spring.springboot.dto.emp.EmpResult;
import com.yjw.spring.springboot.service.EmpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api("员工查询相关api")
@RestController
@RequestMapping("/api/emp")
public class EmpApi {

	@Autowired
	private EmpService empService;
	
	@ApiOperation(value = "测试查询emp", notes = "")
	@PostMapping("/list")
	public Result<?> list() {
		List<Emp> list=empService.findAll();
		return Result.success(list);
	}
	
	@ApiOperation(value = "测试TABLE转游标", notes = "")
	@PostMapping("/findTableChangeCursor")
	public Result<?> findTableChangeCursor() {
		EmpResult result=new EmpResult();
		empService.findTableChangeCursor(result);;
		return Result.success(result);
	}
	
}
