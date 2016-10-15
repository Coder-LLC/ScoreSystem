package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Bean.Student;
import Bean.Teacher;

public class TeacherDao{
	BaseDao bd=new BaseDao();
	PreparedStatement pre = null;
	ResultSet rs=null;
    public Teacher teacherLogin(Teacher tea){ 	
    	Connection con=bd.getConnection();
    	try{
    		String sql="select * from teacher where name=? and password=?";
    		pre=con.prepareStatement(sql);
    		pre.setString(1, tea.getName());
    		pre.setString(2, tea.getPassword());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			tea.setId(rs.getInt("id"));
    			tea.setCourse_id(rs.getInt("course_id"));
    			tea.setName(rs.getString("name"));
    			tea.setPassword(rs.getString("password"));
    		}	
    		else{
    			tea.setName(null);
    			tea.setPassword(null);
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		bd.closeAll(con, pre, rs);
    	}
		return tea;
    }
    
    public List getAllStudent(){
    	Connection con=bd.getConnection();
    	List <Student> list=new ArrayList();
    	try{
    		String sql="select * from student";
    		pre=con.prepareStatement(sql);
    		rs=pre.executeQuery();
    		while(rs.next()){
    			Student student=new Student();
    			student.setId(rs.getInt("id"));
    			student.setName(rs.getString("name"));
    			student.setPassword(rs.getString("password"));
    			student.setTeacher_id(rs.getInt("teacher_id"));
    			list.add(student);
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
    
    public int addStudent(Student student){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    		String sql1="select * from teacher where id=?";
    		pre=con.prepareStatement(sql1);
    		pre.setInt(1, student.getTeacher_id());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			String sql2="insert into student values(null,?,?,?,null)";
    			Connection conn=bd.getConnection();
    			PreparedStatement prep=conn.prepareStatement(sql2);
    			prep.setString(1, student.getName());
    			prep.setString(2, student.getPassword());
    			prep.setInt(3, student.getTeacher_id());
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
    
    public int deleteStudent(Student student){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    		String sql1="select * from student where id=?";
    		pre=con.prepareStatement(sql1);
    		pre.setInt(1, student.getId());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			String sql2="delete from student where id=?";
    			Connection conn=bd.getConnection();
    			PreparedStatement prep=conn.prepareStatement(sql2);
    			prep.setInt(1, student.getId());
    			i=prep.executeUpdate();
    			conn.close();prep.close();
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
    
    public int editStudent(Student student){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    		String sql1="select * from student where id=?";
    		pre=con.prepareStatement(sql1);
    		pre.setInt(1, student.getId());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			String sql2="select * from teacher where id=?";
    			Connection cont=bd.getConnection();
    			PreparedStatement pstm=cont.prepareStatement(sql2);
    			pstm.setInt(1, student.getTeacher_id());
        		rs=pstm.executeQuery();
    			if(rs.next()){
    			    String sql3="update student set name=?,teacher_id=? where id=?";
    			    Connection conn=bd.getConnection();
    			    PreparedStatement prep=conn.prepareStatement(sql3);
    			    prep.setString(1, student.getName());
    			    prep.setInt(2, student.getTeacher_id());
    			    prep.setInt(3, student.getId());
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
    
    public int editScore(Student student){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    		String sql1="select * from student where id=? and teacher_id=?";
    		pre=con.prepareStatement(sql1);
    		pre.setInt(1, student.getId());
    		pre.setInt(2, student.getTeacher_id());
    		rs=pre.executeQuery();
    		if(rs.next()){
    			String sql2="update student set score=? where id=?";
    			Connection conn=bd.getConnection();
    			PreparedStatement prep=conn.prepareStatement(sql2);
    			prep.setInt(1, student.getScore());
    			prep.setInt(2, student.getId());
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
    
    public int editPassword(Teacher tea){
    	Connection con=bd.getConnection();
    	int i=0;
    	try{
    	    String sql="update teacher set password=? where id=?";
    	    pre=con.prepareStatement(sql);
    	    pre.setString(1, tea.getPassword());
    	    pre.setInt(2, tea.getId());
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
