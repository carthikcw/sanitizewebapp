package com.cutomer.sanitize.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomerIdGenerator implements IdentifierGenerator {
@Override
public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
	 	String prefix = "CUST";
	    Connection connection = session.connection();

	    try {
	        Statement statement=connection.createStatement();
	        ResultSet rs=statement.executeQuery("select count(customer_Id) as Id from customer_tab");
	        //ResultSet rs=statement.executeQuery("select max(customer_Id) as Id from customer_tab");
	        if(rs.next())
	        {
	            int id=rs.getInt(1)+1001;
	            String generatedId = prefix + new Integer(id).toString();
	            return generatedId;
	        }
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	return null;
}
}