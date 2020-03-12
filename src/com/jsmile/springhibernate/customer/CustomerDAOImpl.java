package com.jsmile.springhibernate.customer;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
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
		Query<Customer> theQuery = session.createQuery( "FROM Customer ORDER BY lastName", Customer.class );
		// get query result list
		List<Customer> customers = theQuery.getResultList();
		
		// return query result list 
		return customers;
	}

	@Override
	public boolean saveCustomer( Customer _customer )
	{
		boolean success = false;
		try 
		{
			Session session = factory.getCurrentSession();
			// if there is the primary key value, Update()
			// if there is no primary key value, Save()
			session.saveOrUpdate( _customer );
			success = true;			
		} 
		catch ( HibernateException e ) 
		{
			e.getCause();
		}
		
		return success;
	}

	@Override
	public Customer getCustomer( int _customerId )
	{
		Session session = factory.getCurrentSession();
		
		return session.get( Customer.class, _customerId );
	}

	@Override
	public boolean deleteCustomer( int _id )
	{
		boolean success = true;
		
		try 
		{
			Session session = factory.getCurrentSession();
			
			Query query = session.createQuery( 
											"DELETE FROM Customer"
											+ " WHERE id=:customerId" );
			query.setParameter( "customerId", _id );
			query.executeUpdate();
		} 
		catch ( HibernateException e ) 
		{
			success = false;
			System.out.println( "/nDeletion Failed." );
		}
		
		return success;
	}

	@Override
	public List<Customer> searchName( String _searchName )
	{
		Session session = factory.getCurrentSession();
		
		Query query = null;
		if( _searchName != null || _searchName.trim().length() > 0 ) 
		{
			System.out.println( "\nsearchName is : " + _searchName );
/*
			query = session.createQuery( 
												"FROM Customer"
												+ " WHERE lower(firstName) LIKE :theName"
												+ " OR lower(lastName) LIKE :theName"
												, Customer.class
											);
*/			
			query = session.createQuery( "from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class );
			query.setParameter( "theName", "%" + _searchName.toLowerCase() + "%" );
		}
		else 
		{
			System.out.println( "\nsearchName is NULL !!" );
			session = factory.getCurrentSession();
			query = session.createQuery( "FROM Customer", Customer.class );
		}
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}
	
	

	
}
