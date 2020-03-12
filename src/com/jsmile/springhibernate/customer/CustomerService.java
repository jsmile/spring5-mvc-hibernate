package com.jsmile.springhibernate.customer;

import java.io.Serializable;
import java.util.List;

import com.jsmile.springhibernate.entity.Customer;

public interface CustomerService
{
	public List<Customer> getCustomers();

	public boolean saveCustomer( Customer _customer );

	public Customer getCustomer( int _customerId );

	public boolean deleteCustomer( int _id );

	public List<Customer> searchName( String _searchName );

}
