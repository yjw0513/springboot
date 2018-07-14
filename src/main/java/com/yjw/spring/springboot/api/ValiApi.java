package com.yjw.spring.springboot.api;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.yjw.spring.springboot.dto.Result;
import com.yjw.spring.springboot.dto.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Package com.yjw.spring.springboot.controller
 * @Description: TODO(测试hibernate validate)
 * @author: yjw0513
 * @date: 2018年7月14日 下午5:06:17
 */
@Api("swaggerDemoController相关的api")
@RestController
public class ValiApi {

	@ApiOperation(value = "测试hibernate validate", notes = "")
	@PostMapping("/validate")
	public Result<?> validate(@RequestBody @Valid Student demo, BindingResult result) {
		if (result.hasErrors()) {
			List<String> list=Lists.newArrayList();
			for (ObjectError error : result.getAllErrors()) {
				list.add(error.getDefaultMessage());
			}
			return Result.errorMsg(StringUtils.join(list));
		}
		return Result.success();
	}

}
