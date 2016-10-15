package main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Bean.Admin;
import Bean.Course;
import Bean.Teacher;
import Biz.AdminBiz;

public class AdminPart {
	int admin_id=0;
	AdminBiz ab=new AdminBiz();
	public boolean adminLogin(){
		boolean b=false;
    	System.out.print("请输入用户名：");
		Scanner input = new Scanner(System.in);
		String name=input.next();
		System.out.print("请输入密码：");
		String password=input.next();
		Admin adm=new Admin();
		adm.setName(name);
		adm.setPassword(password);
		AdminBiz ab=new AdminBiz();
		int i=0;
		i=ab.adminLogin(adm);
		if(i==1){
			System.out.println("登陆成功，欢迎管理员："+adm.getName());
			b=true;
			admin_id=adm.getId();
		}
		else{
			System.out.println("用户名或密码错误，请重新登陆");
		}
		return b;
    }
	
	public void getAllTeacher(){
		Teacher tea=new Teacher();
		List list=ab.getAllTeacher();
		Iterator <Teacher> it=list.iterator();
		while(it.hasNext()){
			tea=it.next();
			System.out.println("教师编号："+tea.getId()+"\t"+"课程号："+tea.getCourse_id()+"\t"
		                       +"教师姓名"+tea.getName()+"\t"+"密码："+tea.getPassword());
		}
	}
	
	public void getAllCourse(){
		Course cou=new Course();
		List list=ab.getAllCourse();
		Iterator <Course> it=list.iterator();
		while(it.hasNext()){
			cou=it.next();
			System.out.println("课程编号："+cou.getId()+"\t"+"课程名："+cou.getCourse_name());
		}
	}
	
	public void addTeacher(){
		System.out.print("请输入课程号：");
		Scanner input = new Scanner(System.in);
		String course=input.next();
		int course_id=Integer.parseInt(course);
		System.out.print("请输入教师名：");
		String name=input.next();
		System.out.print("请输入密码：");
		String password=input.next();
		Teacher teacher=new Teacher();
		teacher.setCourse_id(course_id);
		teacher.setName(name);
		teacher.setPassword(password);
        int i=ab.addTeacher(teacher);
        if(i==1){
        	System.out.println("添加教师成功");
        }
        else if(i==2){
			System.out.println("课程编号不存在，请检查后重试");
		}
        else{
        	System.out.println("添加教师失败");
        }
	}
	
	public void addCourse(){
		System.out.print("请输入课程名：");
		Scanner input = new Scanner(System.in);
		String course_name=input.next();
		Course course=new Course();
		course.setCourse_name(course_name);
        int i=ab.addCourse(course);
        if(i==1){
        	System.out.println("添加课程成功");
        }
        else{
        	System.out.println("添加课程失败");
        }
	}
	
	public void deleteTeacher(){
		System.out.print("请输入教师编号：");
		Scanner input = new Scanner(System.in);
		int teacher_id=Integer.parseInt(input.next());
		Teacher teacher=new Teacher();
		teacher.setId(teacher_id);
		int i=ab.deleteTeacher(teacher);
		if(i==1){
			System.out.println("删除教师成功");
		}
		else if(i==2){
			System.out.println("教师编号不存在，请检查后重试");
		}
		else{
			System.out.println("删除教师失败");
		}
	}
	
	public void deleteCourse(){
		System.out.print("请输入课程编号：");
		Scanner input = new Scanner(System.in);
		int course_id=Integer.parseInt(input.next());
		Course course=new Course();
		course.setId(course_id);
		int i=ab.deleteCourse(course);
		if(i==1){
			System.out.println("删除课程成功");
		}
		else if(i==2){
			System.out.println("课程编号不存在，请检查后重试");
		}
		else{
			System.out.println("删除课程失败");
		}
	}
	
	public void editCourse(){
		System.out.print("请输入课程编号：");
		Scanner input = new Scanner(System.in);
		int course_id=Integer.parseInt(input.next());
		System.out.print("请输入新课程名：");
		String course_name=input.next();
		Course course=new Course();
		course.setId(course_id);
		course.setCourse_name(course_name);
		int i=ab.editCourse(course);
		if(i==1){
			System.out.println("修改课程成功");
		}
		else if(i==2){
			System.out.println("课程编号不存在，请检查后重试");
		}
		else{
			System.out.println("修改课程失败");
		}
	}
	
	public void editTeacher(){
		System.out.print("请输入教师编号：");
		Scanner input = new Scanner(System.in);
		int id=Integer.parseInt(input.next());
		System.out.print("请输入新课程号：");
		int course_id=Integer.parseInt(input.next());
		System.out.print("请输入新教师名：");
		String name=input.next();
		Teacher teacher=new Teacher();
		teacher.setId(id);
		teacher.setCourse_id(course_id);
		teacher.setName(name);
		int i=ab.editTeacher(teacher);
		if(i==1){
			System.out.println("修改课程成功");
		}
		else if(i==2){
			System.out.println("教师编号不存在，请检查后重试");
		}
		else if(i==3){
			System.out.println("课程编号不存在，请检查后重试");
		}
		else{
			System.out.println("修改课程失败");
		}
	}
	
	public void eaitPassword(){
		System.out.print("请输入新密码：");
		Scanner input = new Scanner(System.in);
		String password=input.next();
		Admin adm=new Admin();
		adm.setId(admin_id);
		adm.setPassword(password);
		int i=ab.editPassword(adm);
		if(i==1){
			System.out.println("修改密码成功");
		}
		else{
			System.out.println("修改密码失败");
		}
	}
}
