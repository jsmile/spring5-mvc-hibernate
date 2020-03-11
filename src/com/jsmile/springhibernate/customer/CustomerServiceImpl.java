package com.jsmile.springhibernate.customer;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsmile.springhibernate.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers()
	{
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public boolean saveCustomer( Customer _customer )
	{
		return customerDAO.saveCustomer( _customer );		
	}

	@Override
	@Transactional
	public Customer getCustomer( int _customerId )
	{
		return customerDAO.getCustomer( _customerId );
	}
	
	
}
