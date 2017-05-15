package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class JDBCUtil {
	public static void main(String[] args) {
    	String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/hibernate";
    	String user = "root";
    	String pass = "qw134679";
    	
    	String sql = "insert into stock (factor) values(?)";
        PreparedStatement pstmt;
        int i = 0;

    	
    	try {
			Class.forName(driver);
	    	Connection conn = DriverManager.getConnection(url,user,pass);
	    	//创建Statement对象
	    	pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setDouble(1, 7.99);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
