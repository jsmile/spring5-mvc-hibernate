package com.jsmile.springhibernate.customer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jsmile.springhibernate.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
	// inject a SessionFactory
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Customer> getCustomers()
	{
		// get a session object;
		Session session = factory.getCurrentSession();
		// execute query
		Query<Customer> theQuery = session.createQuery( "FROM Customer", Customer.class );
		// get query result list
		List<Customer> customers = theQuery.getResultList();
		
		// return query result list 
		return customers;
	}

}
