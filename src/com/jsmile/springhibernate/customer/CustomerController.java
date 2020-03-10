package com.jsmile.springhibernate.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsmile.springhibernate.entity.Customer;

@Controller
@RequestMapping( "/customer" )
public class CustomerController
{
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping( "/list" )
	public String listCustomers( Model _model ) 
	{
		// get customers from the Service
		List<Customer> customers = customerService.getCustomers();
		// add customers to the Model
		_model.addAttribute( "customers", customers );
		
		return "customer/list-customers";
	}
	
	@GetMapping( "/showFormForAdd" )
	public String showFormForAdd( Model _model ) 
	{
		Customer customer = new Customer();
		_model.addAttribute( "customer", customer );
		
		return "customer/customer-form";
	}

}
