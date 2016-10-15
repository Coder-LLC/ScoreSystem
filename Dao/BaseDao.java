package Dao;

import java.sql.*;

public class BaseDao {
	private static String driver ="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/scoresystem";
	private static String user="root";
	private static String password="admin";
		
	public Connection getConnection() {
		Connection con = null;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);			
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
    public void closeAll(Connection con, PreparedStatement pre, 
					ResultSet rs) {
		if(rs != null){
		    try {
				 rs.close();
			} 
		    catch(Exception e) {
			    e.printStackTrace();
			}
		}
		if(pre != null) {
			try{
				pre.close();
			} 
			catch (Exception e) {
					e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
