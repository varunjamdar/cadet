package org.cadet.client.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import org.cadet.client.bean.BeanTest;
import org.cadet.util.model.Constants;
import org.cadet.util.model.ErrorLogging;

public class TestRegister {
	Connection connection;
	Statement statement;
	public TestRegister (Connection connection){
		try{
			this.connection=connection;
		}catch(Exception e)
		{
			ErrorLogging.getInstance().log(Level.SEVERE, e);
		}
		
	};
	
	public BeanTest[] getNotRegisterTestForUser (String CUserName, String CCatName) throws SQLException
	{
		ArrayList<BeanTest> test1= new ArrayList<>();
		
		PreparedStatement statement = connection.prepareStatement(Constants.sqlCommands.getNotRegisterTestForUserSql);
		statement.setString(1, CCatName);
		statement.setString(2, CUserName);
		ResultSet rs = statement.executeQuery();
			
		BeanTest objTest;
			
		while(rs.next()){
				objTest= new BeanTest();
				objTest.setTestName(rs.getString(1));
				objTest.setTestDate(rs.getDate(2));
				objTest.setTestDuration(rs.getInt(3));
				objTest.setTestId(rs.getInt(4));
				test1.add(objTest);
		}
		rs.close();
		statement.close();
				
		return test1.toArray(new BeanTest[test1.size()]);
		
	}
	
	public BeanTest[] getViewAllTestForUser (String CUserName, String CCatName) throws SQLException
	{
		ArrayList <BeanTest> test2 = new ArrayList<>();
		
		PreparedStatement statement = connection.prepareStatement(Constants.sqlCommands.getViewAllTestForUserSql);
		
		statement.setString(1, CCatName);
		statement.setString(2, CUserName);
		ResultSet rs = statement.executeQuery();
				
		BeanTest objTest;
			
		while(rs.next()) {
			
				objTest = new BeanTest();
				objTest.setTestName(rs.getString(1));
				objTest.setTestDate(rs.getDate(2));
				objTest.setTestDuration(rs.getInt(3));
				objTest.setTestId(rs.getInt(4));
					
				if(rs.getDouble(5)==0.0 && rs.getInt(6)==0 && rs.getInt(7)==0 )
						objTest.setTestDesc("Not Attempted");
				else
						objTest.setTestDesc("Attempted");
					
				test2.add(objTest);
			}
				
		rs.close();
		statement.close();
			//connection.close();
		return test2.toArray(new BeanTest[test2.size()]);
		
	}
	
	
	public int setRegisterTestForUser (String CUserName, Integer TestId) throws SQLException
	{
	
		int i=0;
	
		PreparedStatement statement = connection.prepareStatement(Constants.sqlCommands.setRegisterTestForUserSql);
				
		statement.setString(1, CUserName);
		statement.setInt(2, TestId);
		i = statement.executeUpdate();

		statement.close();
		//connection.close();
		
		return i;	
	}
			
	
} 