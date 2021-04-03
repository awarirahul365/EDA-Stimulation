package fallsempackage;
import java.util.*;
import java.io.*;
import java.util.Collection;

class playfaircipher{
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String key=sc.nextLine();
		String plaintext=sc.nextLine();
		char matrix[][]=new char[5][5];
		HashSet<Character>hs=new HashSet<>();
		char chkey[]=key.toCharArray();
		String finkey="";
		for(int i=0;i<key.length();i++)
		{
			char ch=chkey[i];
			if(hs.contains(ch)==false)
			{
				finkey=finkey+ch;
				hs.add(ch);
			}
		}
		for(int i=97;i<=122;i++)
		{
			char alphach=(char)i;
			if(hs.contains(alphach)==false && alphach!='j')
			{
				finkey=finkey+alphach;
			}
		}
		int index=0;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				matrix[i][j]=finkey.charAt(index);
				index++;
			}
		}
		if(plaintext.length()%2!=0)
		{
			plaintext=plaintext+'z';
		}
		char chplaintext[]=plaintext.toCharArray();
		String res="";
		for(int i=0;i<plaintext.length()-1;i=i+2)
		{
			char ch1=chplaintext[i];
			char ch2=chplaintext[i+1];
			int positionrow1=0;
			int positioncol1=0;
			int positionrow2=0;
			int positioncol2=0;
			for(int j=0;j<5;j++)
			{
				for(int k=0;k<5;k++)
				{
					if(matrix[j][k]==ch1)
					{
						positionrow1=j;
						positioncol1=k;
					}
					else if(matrix[j][k]==ch2)
					{
						positionrow2=j;
						positioncol2=k;
					}
				}
			}
			if(positioncol1==positioncol2)
			{
				int nextrowposition1=positionrow1+1;
				int nextrowposition2=positionrow2+1;
				if(nextrowposition1==5)
				{
					nextrowposition1=0;
				}
				if(nextrowposition2==5)
				{
					nextrowposition2=0;
				}
				res=res+matrix[nextrowposition1][positioncol1];
				res=res+matrix[nextrowposition2][positioncol2];
			}
			else if(positionrow1==positionrow2)
			{
				int nextcolpos1=positioncol1+1;
				int nextcolpos2=positioncol2+1;
				if(nextcolpos1==5)
				{
					nextcolpos1=0;
				}
				if(nextcolpos2==5)
				{
					nextcolpos2=0;
				}
				res=res+matrix[positionrow1][nextcolpos1];
				res=res+matrix[positionrow2][nextcolpos2];
			}
			else
			{
				res=res+matrix[positionrow1][positioncol2];
				res=res+matrix[positionrow2][positioncol1];
			}
		}
		System.out.println(res);
	}
}