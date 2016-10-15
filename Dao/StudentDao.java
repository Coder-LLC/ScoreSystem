package Dao;

import java.sql.*;

import Bean.Student;

public class StudentDao{
	BaseDao bd=new BaseDao();
	PreparedStatement pre = null;
	ResultSet rs=null;
    public Student studentLogin(Student stu){ 	
    	Connection con=bd.getConnection();
    	try{
    		String sql="select * from student where name=? and password=?";
    		pre=con.prepareStatement(sql);
    		pre.setString(1, stu.getName());
    		pre.setString(2, stu.getPassword());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			stu.setId(rs.getInt("id"));
    			stu.setName(rs.getString("name"));
    			stu.setPassword(rs.getString("password"));
    		}	
    		else{
    			stu.setName(null);
    			stu.setPassword(null);
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
		return stu;
    }
    
    public Student selectScore(Student stu){ 
    	Connection con=bd.getConnection();
    	PreparedStatement pre = null;
    	ResultSet rs=null;
    	try{
    		String sql="select * from student where id=?";
    		pre=con.prepareStatement(sql);
    		pre.setInt(1, stu.getId());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			stu.setTeacher_id(rs.getInt("teacher_id"));
    			stu.setScore(rs.getInt("score"));
    		}	
    		else{
    			stu.setName(null);
    			stu.setPassword(null);
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
		return stu;
    }
    
    public int editPassword(Student stu){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    	    String sql="update student set password=? where id=?";
    	    pre=con.prepareStatement(sql);
    	    pre.setString(1, stu.getPassword());
    	    pre.setInt(2, stu.getId());
    	    i=pre.executeUpdate();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
    	return i;
    }
}
