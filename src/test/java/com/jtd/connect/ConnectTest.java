package com.jtd.connect;
import java.sql.Connection;  
import java.sql.DriverManager;  
import org.junit.Test;
public class ConnectTest {
    String url="jdbc:mysql://localhost:3306/jtd"; //�������ݿ⣨kucun�����ݿ�����  
    String name="root";//����mysql���û���  
    String pwd="root";//����mysql������  
	@Test 
	public  void closeAll() throws Exception{ 
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url,name,pwd);
	System.out.println(conn);
	}  
}
