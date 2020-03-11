package com.jsmile.springhibernate.customer;

import java.io.Serializable;
import java.util.List;

import com.jsmile.springhibernate.entity.Customer;

public interface CustomerService
{
	public List<Customer> getCustomers();

	public boolean saveCustomer( Customer _customer );

	public Customer getCustomer( int _customerId );

}
