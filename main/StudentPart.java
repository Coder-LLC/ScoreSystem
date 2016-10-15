package main;

import java.util.Scanner;

import Bean.Student;
import Bean.Teacher;
import Biz.StudentBiz;

public class StudentPart {
	StudentBiz sb=new StudentBiz();
   	int student_id=0;
    public boolean studentLogin(){
    	boolean b=false;
    	System.out.print("请输入用户名：");
		Scanner input = new Scanner(System.in);
		String name=input.next();
		System.out.print("请输入密码：");
		String password=input.next();
		Student stu=new Student();
		stu.setName(name);
		stu.setPassword(password);
		int i=0;
		i=sb.studentLogin(stu);
		if(i==1){
			b=true;
			student_id=stu.getId();
			System.out.println("登陆成功，欢迎学生："+stu.getName());
		}
		else{
			System.out.println("用户名或密码错误，请重新登陆");
		}
		return b;
    }
    
    public void selectScore(){
    	Student student=new Student();
    	student.setId(student_id);
    	Student stu=new Student();
    	stu=sb.selectScore(student);
    	System.out.print("成绩为："+student.getScore());
    }
    
    public void eaitPassword(){
		System.out.print("请输入新密码：");
		Scanner input = new Scanner(System.in);
		String password=input.next();
		Student stu=new Student();
		stu.setId(student_id);
		stu.setPassword(password);
		int i=sb.editPassword(stu);
		if(i==1){
			System.out.println("修改密码成功");
		}
		else{
			System.out.println("修改密码失败");
		}
	}
}
