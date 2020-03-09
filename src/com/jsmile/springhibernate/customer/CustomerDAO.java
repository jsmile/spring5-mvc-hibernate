package com.jsmile.springhibernate.customer;

import java.util.List;

import com.jsmile.springhibernate.entity.Customer;

public interface CustomerDAO
{
	public List<Customer> getCustomers();

}
