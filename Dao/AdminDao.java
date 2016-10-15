package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Bean.Admin;
import Bean.Course;
import Bean.Teacher;

public class AdminDao {
	BaseDao bd=new BaseDao();
	PreparedStatement pre = null;
	ResultSet rs=null;
    public Admin adminLogin(Admin adm){
    	Connection con=bd.getConnection();
    	try{
    		String sql="select * from admin where name=? and password=?";
    		pre=con.prepareStatement(sql);
    		pre.setString(1, adm.getName());
    		pre.setString(2, adm.getPassword());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			adm.setId(rs.getInt("id"));
    			adm.setName(rs.getString("name"));
    			adm.setPassword(rs.getString("password"));
    		}	
    		else{
    			adm.setName(null);
    			adm.setPassword(null);
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
		return adm;
    }
    
    public List getAllTeacher(){
    	Connection con=bd.getConnection();
    	List <Teacher> list=new ArrayList();
    	try{
    		String sql="select * from teacher";
    		pre=con.prepareStatement(sql);
    		rs=pre.executeQuery();
    		while(rs.next()){
    			Teacher teacher=new Teacher();
    			teacher.setId(rs.getInt("id"));
    			teacher.setCourse_id(rs.getInt("course_id"));
    			teacher.setName(rs.getString("name"));
    			teacher.setPassword(rs.getString("password"));
    			list.add(teacher);
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
    	return list;
    }
    
    public List getAllCourse(){
    	Connection con=bd.getConnection();
    	List <Course> list=new ArrayList();
    	try{
    		String sql="select * from course";
    		pre=con.prepareStatement(sql);
    		rs=pre.executeQuery();
    		while(rs.next()){
    			Course course=new Course();
    			course.setId(rs.getInt("id"));
    			course.setCourse_name(rs.getString("course_name"));
    			list.add(course);
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
    	return list;
    }
    
    public int addTeacher(Teacher teacher){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    		String sql1="select * from course where id=?";
    		pre=con.prepareStatement(sql1);
    		pre.setInt(1, teacher.getCourse_id());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			String sql2="insert into teacher values(null,?,?,?)";
    			Connection conn=bd.getConnection();
    			PreparedStatement prep=conn.prepareStatement(sql2);
    			prep.setInt(1, teacher.getCourse_id());
    			prep.setString(2, teacher.getName());
    			prep.setString(3, teacher.getPassword());
    			i=prep.executeUpdate();
    			bd.closeAll(conn, prep, rs);
    		}
    		else{
    			i=2;
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
    	return i;
    }
    
    public int addCourse(Course course){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    	    String sql="insert into course values(null,?)";
    	    pre=con.prepareStatement(sql);
    	    pre.setString(1, course.getCourse_name());
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
    
    public int deleteTeacher(Teacher teacher){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    		String sql1="select * from teacher where id=?";
    		pre=con.prepareStatement(sql1);
    		pre.setInt(1, teacher.getId());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			String sql2="delete from teacher where id=?";
    			Connection conn=bd.getConnection();
    			PreparedStatement prep=conn.prepareStatement(sql2);
    			prep.setInt(1, teacher.getId());
    			i=prep.executeUpdate();
    			bd.closeAll(conn, prep, rs);
    		}
    		else{
    			i=2;
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
    	return i;
    }
    
    public int deleteCourse(Course course){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    		String sql1="select * from course where id=?";
    		pre=con.prepareStatement(sql1);
    		pre.setInt(1, course.getId());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			String sql2="delete from course where id=?";
    			Connection conn=bd.getConnection();
    			PreparedStatement prep=conn.prepareStatement(sql2);
    			prep.setInt(1, course.getId());
    			i=prep.executeUpdate();
    			bd.closeAll(conn, prep, rs);
    		}
    		else{
    			i=2;
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
    	return i;
    }
    
    public int editCourse(Course course){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    		String sql1="select * from course where id=?";
    		pre=con.prepareStatement(sql1);
    		pre.setInt(1, course.getId());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			String sql2="update course set course_name=? where id=?";
    			Connection conn=bd.getConnection();
    			PreparedStatement prep=conn.prepareStatement(sql2);
    			prep.setString(1, course.getCourse_name());
    			prep.setInt(2, course.getId());
    			i=prep.executeUpdate();
    			bd.closeAll(conn, prep, rs);
    		}
    		else{
    			i=2;
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
    	return i;
    }
    
    public int editTeacher(Teacher teacher){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    		String sql1="select * from teacher where id=?";
    		pre=con.prepareStatement(sql1);
    		pre.setInt(1, teacher.getId());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			String sql2="select * from course where id=?";
    			Connection cont=bd.getConnection();
    			PreparedStatement pstm=cont.prepareStatement(sql2);
    			pstm.setInt(1, teacher.getCourse_id());
        		rs=pstm.executeQuery();
    			if(rs.next()){
    			    String sql3="update teacher set course_id=?,name=? where id=?";
    			    Connection conn=bd.getConnection();
    			    PreparedStatement prep=conn.prepareStatement(sql3);
    			    prep.setInt(1, teacher.getCourse_id());
    			    prep.setString(2, teacher.getName());
    			    prep.setInt(3, teacher.getId());
    			    i=prep.executeUpdate();
    			    bd.closeAll(conn, prep, rs);
    			}
    			else{
    				i=3;
    			}
    		}	
    		else{
    			i=2;
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
    	return i;
    }
    
    public int editPassword(Admin adm){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    	    String sql="update admin set password=? where id=?";
    	    pre=con.prepareStatement(sql);
    	    pre.setString(1, adm.getPassword());
    	    pre.setInt(2, adm.getId());
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
