package com.jsmile.springhibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="customer" )
public class Customer
{
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
	
	@Column( name="first_name" )
	private String firstName;
	@Column( name="last_name" )
	private String lastName;	
	@Column( name="email" )
	private String email;
	
	
	public Customer() { }
	public Customer( String _firstName, String _lastName, String _email )
	{
		firstName = _firstName;
		lastName = _lastName;
		email = _email;
	}
	
	
	public int getId() { return id; }
	public void setId( int _id ) { id = _id; }
	
	public String getFirstName() { return firstName; }
	public void setFirstName( String _firstName ) { firstName = _firstName; }
	
	public String getLastName() { return lastName; }
	public void setLastName( String _lastName ) { lastName = _lastName; }
	
	public String getEmail() { return email; }
	public void setEmail( String _email ) { email = _email; }
	
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append( "Customer [id=" );
		builder.append( id );
		builder.append( ", firstName=" );
		builder.append( firstName );
		builder.append( ", lastName=" );
		builder.append( lastName );
		builder.append( ", email=" );
		builder.append( email );
		builder.append( "]" );
		return builder.toString();
	}

}
