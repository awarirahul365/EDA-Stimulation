package fallsempackage;
import java.util.*;

class EmployeeDetails{
	
	public String name;
	public int salary;
	public int hoursworked;
	public void getInfo(String name,int salary,int hoursworked)
	{
		this.name=name;
		this.salary=salary;
		this.hoursworked=hoursworked;
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
	}
}
public class employee{
	
	public static void main(String args[])
	{
		Address a=new Address();
		a.getInfo("Rahul", 50, 7);
		a.getaddress("Pune");
		a.display();
	}
}