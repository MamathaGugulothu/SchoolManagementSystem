package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class school 
{
	 private static String conn;
	 private  static Connection con;
	 private static Statement stat=null;
	 static  Scanner sc=new Scanner(System.in); 
	 private static int id;
static 
{
	 conn="com.mysql.cj.jdbc.Driver";
	  Connection con=null;
	  //user="root";
	  //pass="Mam@9573";
}
	static Connection connect() throws ClassNotFoundException, SQLException {
	
		Class.forName(conn);
		con=DriverManager.getConnection("JDBC:MYSQL://localhost:3306/db6355","root","Mam@9573");
		
			//stat=con.createStatement();
			
		return con;
		
}
	static void StudentRecord() throws SQLException, ClassNotFoundException
	{
		int Rollno;
		String sName;
		String grade;
		String classno;
		int fees;
		Connection con=connect();
		stat=con.createStatement();
		while(true) {
		System.out.println("1.Add Student Details");
		System.out.println("2.Update Student Details");
		System.out.println("3.Delete Student Details");
		System.out.println("4.Retrieve Student Details");
		System.out.println("5.Exit");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("Enter Student Details ");

			System.out.println("Enter student Rollno");
			 Rollno = sc.nextInt();
			 System.out.println("Enter Student Name");
			  sName = sc.next();
			 System.out.println("Enter Grade");
			  grade = sc.next();
			 System.out.println("Enter class Name");
			 classno = sc.next();
			 System.out.println("Enter fees paid ");
			 fees = sc.nextInt();		 
			 String str="select * from Stud where Rollno="+Rollno;
			 ResultSet rs=stat.executeQuery(str);
			 if(!rs.next()) 
			 {
			 String ins="insert into Stud values("+Rollno+",'"+sName+"','"+classno+"','"+grade+"',"+fees+")";
			 int i=stat.executeUpdate(ins);
			 if(i>0)
			 {
				 System.out.println("student Record is Added ");
			 }
			 }
			 else 
			 {
				 System.out.println(Rollno+"Already exits:");
			 }
			 break;
		case 2:
			System.out.println("Enter student  id to update Record \n");
			Rollno=sc.nextInt();
			 String str1="select * from Stud where Rollno="+Rollno;
			 ResultSet rs1=stat.executeQuery(str1);
			 if(rs1.next()) {
				 System.out.println("value is persent");
				 System.out.println("Enter a Fees to be change");
				 fees=sc.nextInt();
				 String updated="update Stud set fees="+ fees +" where Rollno="+Rollno;
				 int i=stat.executeUpdate(updated);
				 if(i>0) {
					 System.out.println("Record is updated");
				 }
				 
			 }else {
				 System.out.println(id+" not Exits");
			 }
			 break;
		case 3:
			System.out.println("Enter student  Rollno to delete Record \n");
			 Rollno = sc.nextInt();
			 String str11="select * from Stud where Rollno="+Rollno;
			 ResultSet rs11=stat.executeQuery(str11);
			 if(rs11.next()) {
				 System.out.println("value is present");
				 String del="Delete from Stud where Rollno="+Rollno;
				 int i=stat.executeUpdate(del);
				 if(i>0) {
					 System.out.println("Record is Deleted");
				 }
				 
			 }else {
				 System.out.println(id+" not Exits");
			 }
			 break;
		case 4:
			System.out.println(" Student Details are:");

			ResultSet rs111=stat.executeQuery("select * from Stud");
			System.out.println("Rollno \t Name \t class \t grade \t fees");
			while(rs111.next()) {
				System.out.println(rs111.getInt(1)+"\t"+rs111.getString(2)+"\t"+rs111.getString(3)+"\t"+rs111.getString(4)+"\t"+rs111.getInt(5));
			}
			break;
		case 5:
			System.out.println("Exit");
			main(null);
			default:
				System.out.println("Invalid choices");
				break;
		}
		}		
	}
	static void Teacher() throws SQLException, ClassNotFoundException
	{
		int empid;
		String ename;
		String sub;
		double salary;
		Connection con=connect();
		stat=con.createStatement();
		while(true) {
		System.out.println("Menu");
		System.out.println("1.Add Teacher Details");
		System.out.println("2.Update Teacher Details");
		System.out.println("3.Delete Teacher Details");
		System.out.println("4.Retrieve Teacher Details");
		System.out.println("5.Exit");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("Enter Employee Details");
			System.out.println("Enter Teacher Id :");
			empid = sc.nextInt();
			System.out.println("Enter Teacher Name :");
			ename = sc.next();
			System.out.println("Enter the Subject:");
			 sub = sc.next();
			System.out.println("Enter salary of teacher:");
			salary = sc.nextDouble();
			 String str1="select * from Teacher where empid="+empid;
			 ResultSet rs1=stat.executeQuery(str1);
			 System.out.println("Record Inserted");
			 if(!rs1.next()) 
			 {
			 String ins="insert into Teacher values("+empid+",'"+ename+"',"+salary+",'"+sub+"')";
			 int i=stat.executeUpdate(ins);
			 if(i>0)
			 {
				 System.out.println("Teacher Record is Added ");
			 }
			 }
			 else 
			 {
				 System.out.println(empid+"Already exits:");
			 }
			break;
		case 2:
			System.out.println("Enter Teacher id to update Record \n");
				empid=sc.nextInt();
			 String str11="select * from Teacher where empid="+empid;
			 ResultSet rs11=stat.executeQuery(str11);
			 
			 if(rs11.next()) {
				 System.out.println("value is persent");
				 System.out.println("Enter a salary to be change");
				 salary=sc.nextInt();
				String updated="update Teacher set salary="+ salary +" where empid="+empid;
				 int i=stat.executeUpdate(updated);
				 if(i>0) {
					 System.out.println("Record is updated");
				 }
				 
			 }else {
				 System.out.println(id+" not Exits");
			 }
			 break;
		case 3:
			System.out.println("Enter Employee id to delete Record \n");
			 empid = sc.nextInt();
			 String str="select * from Teacher where empid="+empid;
			 ResultSet rs=stat.executeQuery(str);
			 
			 if(rs.next()) {
				 System.out.println("value is present");
				 String del="Delete from Teacher where empid="+empid;
				 int i=stat.executeUpdate(del);
				 if(i>0) {
					 System.out.println("Record is Deleted");
				 }
				 
			 }else {
				 System.out.println(id+" not Exits");
			 }
			 break;
		case 4:
			ResultSet rs111=stat.executeQuery("select * from Teacher");
			System.out.println("Empid \t Name \t Salary Subject");
			while(rs111.next()) {
				System.out.println(rs111.getInt(1)+"\t"+rs111.getString(2)+"\t"+rs111.getDouble(3)+"\t"+rs111.getString(4));
			}
		break; 
		case 5:
			System.out.println("Exit");
			main(null);
			default:
				System.out.println("Invalid choices");
				break;

		}
		}
	}
	
		static void Expenses() throws SQLException, ClassNotFoundException
	{
		while(true) {
		System.out.println("Menu");
		System.out.println("1.Add Expenses");
		System.out.println("2.View Expenses");
		System.out.println("3.Total Expenses");
		System.out.println("4.Total Income");
		System.out.println("5. Menu");
		int ch = sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("Adding Expenses");
			Connection con= connect();
			stat=con.createStatement();
			System.out.println("Enter student info \n id \n etype \n amount \n");
			 int id = sc.nextInt();
			 String etype = sc.next();
			 int amount = sc.nextInt();		 
			 String str="select * from expenses where id="+id;
			 ResultSet rs=stat.executeQuery(str);
			 System.out.println("Record Inserted");
			 if(!rs.next()) 
			 {
			 String ins="insert into expenses values("+id+",'"+etype+"',"+amount+")";
			 int i=stat.executeUpdate(ins);
			 if(i>0)
			 {
				 System.out.println("Expenses Record is Added ");
			 }
			 }
			 else 
			 {
				 System.out.println(id+"Already exits:");
			 }
			break;
		case 2:
			System.out.println("View Expenses");
			Connection con1= connect();
			stat=con1.createStatement();
			ResultSet rs1=stat.executeQuery("select * from expenses");
			System.out.println("id \t etype \t amount \t");
			while(rs1.next()) {
				System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getInt(3));
			}
			break;
		case 3:
			Connection con11= connect();
			stat=con11.createStatement();
			System.out.println("Salaries given:");
			ResultSet rs11=stat.executeQuery("select sum(salary)from Teacher");
			while(rs11.next())
			{
				System.out.println(rs11.getInt(1));
			}
			System.out.println("Other Expenses");
			ResultSet rs2=stat.executeQuery("select sum(amount)from expenses");
			while(rs2.next())
			{
				System.out.println(rs2.getInt(1));
			}

			System.out.println(" Total Expenses:");
			ResultSet rs111=stat.executeQuery("select(select sum(amount) from expenses)+(select sum(salary)from Teacher)");
			while(rs111.next())
			{
				System.out.println(rs111.getInt(1));
			}
			break;
		case 4:
			Connection con111= connect();
			stat=con111.createStatement();
			System.out.println(" Total Income:");
			ResultSet rs1111=stat.executeQuery("select sum(fees) from Stud");
			while(rs1111.next())
			{
				System.out.println(rs1111.getInt(1));
			}
			System.out.println("Remaining Balance After Reducing Expenses:");
			ResultSet rs3=stat.executeQuery("select(select sum(fees) from Stud)-(select sum(amount) from expenses)-(select sum(salary) from Teacher)");
			while(rs3.next())
			{
				System.out.println(rs3.getInt(1));
			}
			break;
		case 5:
			System.out.println("Exit");
			main(null);
			case 6:
			default:
				System.out.println("Invalid choices");
				break;
		}
		}
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		school obj=new school();
		while(true) {
			System.out.println("1. Student");
			System.out.println("2. Teacher");
			System.out.println("3. Revenue");
			System.out.println("4. Exit");
			int ch=school.sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println(" About Student");
				obj.StudentRecord();
				break;
			case 2:
				System.out.println("About Teacher");
				obj.Teacher();
				break;
			case 3:
				System.out.println("Revenue");
				obj.Expenses();
				break;
			case 4:
				System.out.println("exit");
				System.exit(0);
			default:
				System.out.println("Invalid Choices");
				break;
			}
		}
	}
}
