package com.yjw.spring.springboot.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.yjw.spring.springboot.dto.Student;
/**
 * @Package com.yjw.spring.springboot.controller   
 * @Description:    TODO(测试hibernate validate)   
 * @author: yjw0513     
 * @date:   2018年7月14日 下午5:06:17   
 */
@RestController
public class ValidateController {

	@PostMapping("/validate")
	public void validate(@RequestBody @Valid Student demo, BindingResult result) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
		}
	}
}
