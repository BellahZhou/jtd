package com.jtd.connect;
import java.sql.Connection;  
import java.sql.DriverManager;  
import org.junit.Test;
public class ConnectTest {
    String url="jdbc:mysql://localhost:3306/jtd"; //连接数据库（kucun是数据库名）  
    String name="root";//连接mysql的用户名  
    String pwd="root";//连接mysql的密码  
	@Test 
	public  void closeAll() throws Exception{ 
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url,name,pwd);
	System.out.println(conn);
	}  
}
