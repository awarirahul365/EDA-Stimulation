package fallsempackage;
import java.util.*;
import java.io.*;

class calculator{
	
	public static int[] getgcd(int num1,int num2)
	{
		int r1=num1;
		int r2=num2;
		int s1=1;
		int s2=0;
		int s=0;
		int t1=0;
		int t2=1;
		int t=0;
		int q=0;
		int rem=0;
		while(r2!=0)
		{
			q=r1/r2;
			rem=r1%r2;
			r1=r2;
			r2=rem;
			s=s1-q*s2;
			t=t1-q*t2;
			s1=s2;
			s2=s;
			t1=t2;
			t2=t;
		}
		int ans[]=new int[3];
		ans[0]=r1;
		ans[1]=t1;
		ans[2]=t2;
		return ans;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int outp[]=new int[3];
		outp=getgcd(num1,num2);
		System.out.println("GCD is " + outp[0]);
		System.out.println("multipicative inverse " + outp[1]);
		System.out.println("second possible multiplicative inverse " + outp[2]);
	}
}