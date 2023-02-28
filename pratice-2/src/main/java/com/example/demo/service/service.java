package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.model;
import com.example.demo.repository.repository;

@Service
public class service {

	@Autowired
	repository r;
	
	public String add(model m1)
	{
		r.save(m1);
		return "Added";
	}
	
	public List<model>getDetails()
	{
		return r.findAll();
	}
	
	public model updateDetails(model m2)
	{
		return r.saveAndFlush(m2);
	}
	
	public void deleteDetails(int id)
	{
		r.deleteById(id);
	}
	
	public List<model>getSorted(String field)
	{
		return r.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public List<model> getWithPagination(@PathVariable int offset,@PathVariable int pageSize)
	{
		Page<model>page = r.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
