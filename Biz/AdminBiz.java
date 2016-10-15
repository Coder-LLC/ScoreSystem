package Biz;

import java.util.List;

import Bean.Admin;
import Bean.Course;
import Bean.Teacher;
import Dao.AdminDao;

public class AdminBiz {
	 AdminDao ad=new AdminDao();
	 public int adminLogin(Admin adm){
	     int flag=0;	
	     String name=adm.getName();    	
	     String password=adm.getPassword();
	     AdminDao ad=new AdminDao();
	     Admin admin=ad.adminLogin(adm);	
	     if(name.equals(admin.getName())&&password.equals(admin.getPassword())){
	    	flag=1;
	     }
	     return flag;
	  }
	 
	 public List getAllTeacher(){
		 List <Teacher> list=ad.getAllTeacher();
		 return list;
	 }
	 
	 public List getAllCourse(){
		 AdminDao ad=new AdminDao();
		 List <Course> list=ad.getAllCourse();
		 return list;
	 }
	 
	 public int addTeacher(Teacher teacher){
		 int i=ad.addTeacher(teacher);
		 return i;
	 }
	 
	 public int addCourse(Course course){ 
		 int i=ad.addCourse(course);
		 return i;
	 }
	 
	 public int deleteTeacher(Teacher teacher){
		 int i=ad.deleteTeacher(teacher);
		 return i;
	 }
	 
	 public int deleteCourse(Course course){
		 int i=ad.deleteCourse(course);
		 return i;
	 }
	 
	 public int editCourse(Course course){
		 int i=ad.editCourse(course);
		 return i;
	 }
	 
	 public int editTeacher(Teacher teacher){
		 int i=ad.editTeacher(teacher);
		 return i;
	 }
	 
	 public int editPassword(Admin adm){
		 int i=ad.editPassword(adm);
		 return i;
	 }
}
