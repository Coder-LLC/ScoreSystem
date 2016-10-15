package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean begin=true;
		while(begin){
		  System.out.println("欢迎使用系统");
		  System.out.println("请选择登陆角色(按123)："+"\t"+"1.管理员"+"\t"+"2.老师"+"\t"+"3.学生"
				            + "\t"+"按其他键退出系统");
		  Scanner input = new Scanner(System.in);
		  String login=input.next();
		  if(login.equals("1")){
			  AdminPart ap=new AdminPart();
			  boolean b=false;
			  b=ap.adminLogin();
			  if(b==true){
				  boolean bool=true;
				  while(bool){
				      System.out.println("请选择操作："+"\t"+"1.查询所有教师"+"\t"+"2.查询所有课程"+"\t"+
			                            "3.添加教师"+"\t"+"4.添加课程"+"\t"+"5.删除教师"+"\t"+"6.删除课程"+
			                            "\t"+"7.编辑课程信息"+"\t"+"8.编辑教师信息"+"\t"+"9.修改密码"
			                            +"\t"+"按其他键退回上级菜单");
				      String choose=input.next();
				      if(choose.equals("1")){
					      ap.getAllTeacher();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("2")){
				    	  ap.getAllCourse();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("3")){
				    	  ap.addTeacher();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("4")){
				    	  ap.addCourse();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("5")){
				    	  ap.deleteTeacher();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("6")){
				    	  ap.deleteCourse();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("7")){
				    	  ap.editCourse();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("8")){
				    	  ap.editTeacher();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("9")){
				    	  ap.eaitPassword();
				    	  System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else{
				    	  System.out.println("退回上级菜单");
				    	  bool=false;
				    	  b=false;
				      }
			      }
			  }
			  else{
				  b=false;
			  }
		  }
		  else if(login.equals("2")){
			  TeacherPart tp=new TeacherPart();
			  boolean b=false;
			  b=tp.teacherLogin();
			  if(b==true){
				  boolean bool=true;
				  while(bool){
				      System.out.println("请选择操作："+"\t"+"1.查询所有学生"+"\t"+"2.添加学生"+"\t"+
			                            "3.删除学生"+"\t"+"4.编辑学生信息"+"\t"+"5.编辑学生成绩"+"\t"+"6.修改密码"
			                            +"\t"+"按其他键退回上级菜单");
				      String choose=input.next();
				      if(choose.equals("1")){
					      tp.getAllStudent();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("2")){
				    	  tp.addStudent();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("3")){
				    	  tp.deleteStudent();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("4")){
				    	  tp.editStudent();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("5")){
				    	  tp.editScore();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("6")){
				    	  tp.eaitPassword();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else{
				    	  System.out.println("退回上级菜单");
				    	  bool=false;
				    	  b=false;
				      }
			      }
			  }
			  else{
				  b=false;
			  }
		  }
		  else if(login.equals("3")){
			  StudentPart sp=new StudentPart();
			  boolean b=false;
			  b=sp.studentLogin();
			  if(b==true){
				  boolean bool=true;
				  while(bool){
				      System.out.println("请选择操作："+"\t"+"1.查询成绩："+"\t"+"2.修改密码"
			                            +"\t"+"按其他键退回上级菜单");
				      String choose=input.next();
				      if(choose.equals("1")){
					      sp.selectScore();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      }
				      else if(choose.equals("2")){
				    	  sp.eaitPassword();
					      System.out.println("请选择操作："+"\t"+"按1继续"+"\t"+"按其他键退回上级菜单");
					      String str=input.next();
					      if(str.equals("1")){
					    	  bool=true;
					      }
					      else{
					    	  bool=false;
					    	  b=false;	    	
					      }
				      } 
				      else{
				    	  System.out.println("退回上级菜单");
				    	  bool=false;
				    	  b=false;
				      }
			      }
			  }
			  else{
				  b=false;
			  }
		  }
		  else{
			System.out.println("系统退出，感谢使用");
			begin=false;
		  }
	   }
		
    }
}
