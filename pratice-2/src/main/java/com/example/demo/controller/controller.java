package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.model;
import com.example.demo.service.service;

@RestController
public class controller {

	@Autowired
	service s;
	
	@PostMapping("/post")
	public String addDetails(@RequestBody model e1)
	{
		s.add(e1);
		return "Added Product"+e1.getBabyId();
	}
	
	@GetMapping("/get")
	public List<model>showDetails()
	{
		return s.getDetails();
	}
	
	@PutMapping("/updateDetails")
	public model updateinfo(@RequestBody model e2)
	{
		return s.updateDetails(e2);
	}
	
	@DeleteMapping("/delete/{babyId}")
	public String deleteinfo(@PathVariable("BabyId") int BabyId)
	{
		s.deleteDetails(BabyId);
		return "Deleted Items";
	}
	
	@GetMapping("/product/{field}")
	public List<model> getWithSort(@PathVariable String field)
	{
		return s.getSorted(field);
	}
	
	@GetMapping("/product/{offset}/{pageSize}")
	public List<model> productsWithPagination(@PathVariable int offset,@PathVariable int pageSize)
	{
		return s.getWithPagination(offset,pageSize);
	}
	
	
	
	
	
	
	
	
	
}
