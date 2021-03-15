package fallsempackage;
import java.util.*;
import java.io.*;

class chineseremainder{
	
	public static int getgcdMul(int num1,int num2)
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
		int diff=t2+t1;
		if(diff>0)
		{
			return diff;
		}
		else
		{
			return t1;
		}
	}
	public static void getMultiplicative(int normalarray[],int multiverse[],int m[])
	{
		for(int i=0;i<normalarray.length;i++)
		{
			multiverse[i]=getgcdMul(m[i],normalarray[i]);
		}
	}
	public static void getnormalarray(int normalarray[],int Mtotal,int m[])
	{
		for(int i=0;i<m.length;i++)
		{
			normalarray[i]=Mtotal/m[i];
		}
	}
	public static int getM(int m[])
	{
		int M=1;
		for(int i=0;i<m.length;i++)
		{
			M=M*m[i];
		}
		return M;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		int m[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			m[i]=sc.nextInt();
		}
		int Mtotal;
		Mtotal=getM(m);
		int normalarray[]=new int[n];
		getnormalarray(normalarray,Mtotal,m);
		int multiverse[]=new int[n];
		getMultiplicative(normalarray,multiverse,m);
		int res=0;
		for(int i=0;i<n;i++)
		{
			res=res+normalarray[i]*a[i]*multiverse[i];
		}
		int finaloutp=0;
		finaloutp=res%Mtotal;
		System.out.println(finaloutp);
	}
}