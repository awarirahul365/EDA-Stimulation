package fallsempackage;
import java.util.*;

class EmployeeDetails{
	
	public String name;
	public int salary;
	public int hoursworked;
	public String companyname;
	public void getInfo(String name,int salary,int hoursworked,String companyname)
	{
		this.name=name;
		this.salary=salary;
		this.hoursworked=hoursworked;
		this.companyname=companyname;
	}
	public void addsalary()
	{
		if(salary<500)
		{
			salary=salary+10;
		}
	}
	public void AddWork()
	{
		if(hoursworked>6)
		{
			salary=salary+6;
		}
	}
}
class Location{
	
	protected String location;
	public void getlocation(String location)
	{
		this.location=location;
	}
}
class Address extends EmployeeDetails{
	
	private String address;
	public void getaddress(String address)
	{
		this.address=address;
	}
	public void display()
	{
		System.out.println("Name is " + name);
		System.out.println("salary is " + salary);
		System.out.println("Hours Worked " + hoursworked);
		System.out.println("Address " + address);
		System.out.println("Company Name " + super.companyname);
	}
}
class contactdetails extends EmployeeDetails{
	
	public String phonenumber;
	public void getphonenumber(String phonenumber)
	{
		this.phonenumber=phonenumber;
	}
	public void displaywithcontact()
	{
		if(phonenumber.length()==10)
		{
			System.out.println("Name is " + name);
			System.out.println("salary is " + salary);
			System.out.println("Hours Worked " + hoursworked);
			System.out.println("Company Name " + super.companyname);
		}
		else
		{
			System.out.println("Invalid");
		}
	}
}
public class employee{
	
	public static void main(String args[])
	{
		Address a=new Address();
		contactdetails c=new contactdetails();
		a.getInfo("Rahul", 50, 7,"AAM");
		a.getaddress("Pune");
		a.display();
		c.getphonenumber("9867577890");
		c.displaywithcontact();
	}
}