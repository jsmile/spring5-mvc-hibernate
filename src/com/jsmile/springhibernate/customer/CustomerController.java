package com.jsmile.springhibernate.customer;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping( "/saveCustomer" )
	public String saveCustomer( @ModelAttribute( "customer" ) Customer _customer ) 
	{
		Boolean result = customerService.saveCustomer( _customer );
		System.out.println( "Save Result : " + result );
		
		return "redirect:/customer/list";
	}
	
	@GetMapping( "/showFormForUpdate" )
	public String showFormForUpdate( @RequestParam( "customerId" ) int _id, Model _model ) 
	{
		Customer customer = customerService.getCustomer( _id );
		
		_model.addAttribute( "customer", customer );
		
		return "customer/customer-form";
		
	}

}
