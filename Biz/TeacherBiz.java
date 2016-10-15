package Biz;

import java.util.List;

import Bean.Student;
import Bean.Teacher;
import Dao.TeacherDao;

public class TeacherBiz {
	TeacherDao td=new TeacherDao();
   
	public int teacherLogin(Teacher tea){
    	int flag=0;   
    	String name=tea.getName();    	
    	String password=tea.getPassword();
    	TeacherDao td=new TeacherDao();
    	Teacher teacher=td.teacherLogin(tea);	
    	if(name.equals(teacher.getName())&&password.equals(teacher.getPassword())){
    		flag=1;
    	}
    	return flag;
    }
	
	 public List getAllStudent(){
		 List <Student> list=td.getAllStudent();
		 return list;
	 }
	 
	 public int addStudent(Student student){
		 int i=td.addStudent(student);
		 return i;
	 }
	 
	 public int deleteStudent(Student student){
		 int i=td.deleteStudent(student);
		 return i;
	 }
	 
	 public int editStudent(Student student){
		 int i=td.editStudent(student);
		 return i;
	 }
	 
	 public int editScore(Student student){
		 int i=td.editScore(student);
		 return i;
	 }
	 
	 public int editPassword(Teacher tea){
		 int i=td.editPassword(tea);
		 return i;
	 }
}