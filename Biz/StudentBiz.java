package Biz;

import Bean.Student;
import Dao.StudentDao;

public class StudentBiz {
	StudentDao sd=new StudentDao();

	public int studentLogin(Student stu){
		int flag=0;   
    	String name=stu.getName();    	
    	String password=stu.getPassword();
    	StudentDao sd=new StudentDao();
    	Student student=sd.studentLogin(stu);	
    	if(name.equals(student.getName())&&password.equals(student.getPassword())){
    		flag=1;
    	}
    	return flag;
    }
    
    public Student selectScore(Student stu){
    	Student student=new Student();
    	student=sd.selectScore(stu);
    	return student;
    }
    
    public int editPassword(Student stu){
    	int i=sd.editPassword(stu);
    	return i;
    }
}
