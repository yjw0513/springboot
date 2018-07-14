package com.yjw.spring.springboot.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yjw.spring.springboot.dto.Student;

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
