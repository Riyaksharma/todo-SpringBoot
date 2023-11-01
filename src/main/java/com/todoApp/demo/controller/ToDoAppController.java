package com.todoApp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todoApp.demo.repo.ToDoAppRepo;

import io.micrometer.common.lang.NonNull;

import com.todoApp.demo.model.ToDoAppModel;


@Controller
@RequestMapping(value="/todo")
public class ToDoAppController 
{
	@Autowired
	ToDoAppRepo repo;
	
	@GetMapping("/tasks")
	public String getTasks()
	{
		return repo.findAll().toString();
	}
	
	@PostMapping("/update")
	public ToDoAppModel save(@RequestBody @Validated @NonNull ToDoAppModel items) 
	{
		repo.save(items);
		return items;
	}
}
