package main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Bean.Admin;
import Bean.Student;
import Bean.Teacher;
import Biz.TeacherBiz;

public class TeacherPart {
	TeacherBiz tb=new TeacherBiz();
	int teacher_id=0;
	public boolean teacherLogin(){
		boolean b=false;
    	System.out.print("请输入用户名：");
		Scanner input = new Scanner(System.in);
		String name=input.next();
		System.out.print("请输入密码：");
		String password=input.next();
		Teacher tea=new Teacher();
		tea.setName(name);
		tea.setPassword(password);
		TeacherBiz tb=new TeacherBiz();
		int i=0;
		i=tb.teacherLogin(tea);
		if(i==1){
			b=true;
			teacher_id=tea.getId();
			System.out.println("登陆成功，欢迎老师："+tea.getName());
		}
		else{
			System.out.println("用户名或密码错误，请重新登陆");
		}
		return b;
    }
	
	public void getAllStudent(){
		Student stu=new Student();
		List list=tb.getAllStudent();
		Iterator <Student> it=list.iterator();
		while(it.hasNext()){
			stu=it.next();
			System.out.println("学生编号："+stu.getId()+"\t"+"学生姓名"+stu.getName()+"\t"
			                   +"密码："+stu.getPassword()+"\t"+"教师编号："+stu.getTeacher_id());
		}
	}
	
	public void addStudent(){
		System.out.print("请输入姓名：");
		Scanner input = new Scanner(System.in);
		String name=input.next();
		System.out.print("请输入密码：");
		String password=input.next();
		Student student=new Student();
		student.setName(name);
		student.setPassword(password);
		student.setTeacher_id(teacher_id);
        int i=tb.addStudent(student);
        if(i==1){
        	System.out.println("添加学生成功");
        }
        else if(i==2){
			System.out.println("教师编号不存在，请检查后重试");
		}
        else{
        	System.out.println("添加学生失败");
        }
	}
	
	public void deleteStudent(){
		System.out.print("请输入学生学号：");
		Scanner input = new Scanner(System.in);
		int student_id=Integer.parseInt(input.next());
		Student student=new Student();
		student.setId(student_id);
		int i=tb.deleteStudent(student);
		if(i==1){
			System.out.println("删除学生成功");
		}
		else if(i==2){
			System.out.println("学生学号不存在，请检查后重试");
		}
		else{
			System.out.println("删除学生失败");
		}
	}
	
	public void editStudent(){
		System.out.print("请输入学生学号：");
		Scanner input = new Scanner(System.in);
		int id=Integer.parseInt(input.next());
		System.out.print("请输入新教师编号：");
		int teacher_id=Integer.parseInt(input.next());
		System.out.print("请输入新学生名：");
		String name=input.next();
		Student student=new Student();
		student.setId(id);
		student.setTeacher_id(teacher_id);
		student.setName(name);
		int i=tb.editStudent(student);
		if(i==1){
			System.out.println("修改学生信息成功");
		}
		else if(i==2){
			System.out.println("学生学号不存在，请检查后重试");
		}
		else if(i==3){
			System.out.println("教师编号不存在，请检查后重试");
		}
		else{
			System.out.println("修改学生信息失败");
		}
	}
	
	public void editScore(){
		System.out.print("请输入学生学号：");
		Scanner input = new Scanner(System.in);
		int id=Integer.parseInt(input.next());
		System.out.print("请输入成绩：");
		int score=Integer.parseInt(input.next());
		Student student=new Student();
		student.setTeacher_id(teacher_id);
		student.setId(id);
		student.setScore(score);
		int i=tb.editScore(student);
		if(i==1){
			System.out.println("修改成绩成功");
		}
		else if(i==2){
			System.out.println("学生学号不存在或不是您的学生，请检查后重试");
		}
		else{
			System.out.println("修改成绩失败");
		}
	}
	
	public void eaitPassword(){
		System.out.print("请输入新密码：");
		Scanner input = new Scanner(System.in);
		String password=input.next();
		Teacher tea=new Teacher();
		tea.setId(teacher_id);
		tea.setPassword(password);
		int i=tb.editPassword(tea);
		if(i==1){
			System.out.println("修改密码成功");
		}
		else{
			System.out.println("修改密码失败");
		}
	}
}
