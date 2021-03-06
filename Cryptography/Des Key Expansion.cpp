#include<iostream>
#include<bits/stdc++.h>
using namespace std;
/*123456ABCD132536
AABB09182736CCDD
2*/
vector<string>vect;
string func1[16]={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
string func2[16]={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
string initialpermutation(string plaintextbin)
{
	int initial_permutation[64] = { 
	58,50,42,34,26,18,10,2, 
	60,52,44,36,28,20,12,4, 
	62,54,46,38,30,22,14,6, 
	64,56,48,40,32,24,16,8, 
	57,49,41,33,25,17,9,1, 
	59,51,43,35,27,19,11,3, 
	61,53,45,37,29,21,13,5, 
	63,55,47,39,31,23,15,7 
	};
	string strinitpermutation="";
	for(int i=0;i<plaintextbin.length();i++)
	{
		strinitpermutation=strinitpermutation+plaintextbin[initial_permutation[i]-1];
	}
	return strinitpermutation;
}
string hexbinfunc(string keyhex)
{
	string r="";
	map<string,string>mp2;
	for(int i=0;i<16;i++)
	{
		mp2[func2[i]]=func1[i];
	}
	for(int i=0;i<keyhex.length();i++)
	{
		string pz="";
		pz=pz+keyhex[i];
		string chz=mp2[pz];
		r=r+chz;
	}
	return r;
}
string binhexfunc(string strcon)
{
	string res="";
	map<string,string>mp;
	for(int i=0;i<16;i++)
	{
		mp[func1[i]]=func2[i];
	}
	for(int i=0;i<strcon.length();i=i+4)
	{
		string t=strcon.substr(i,4);
		string chp=mp[t];
		res=res+chp;
	}
	return res;
}
string onebitshift(string str1)
{
	char ch=str1[0];
	for(int i=1;i<str1.length();i++)
	{
		str1[i-1]=str1[i];
	}
	str1[str1.length()-1]=ch;
	return str1;
}
string twobitshift(string str2)
{
	for(int i=0;i<2;i++)
	{
		char temp=str2[0];
		for(int j=1;j<str2.length();j++)
		{
			str2[j-1]=str2[j];
		}
		str2[str2.length()-1]=temp;
	}
	return str2;
}
void generatekey(string key)
{
	//convert 64-bit key to 56-bit key
	int paritybox1[56] = {
	57,49,41,33,25,17,9, 
	1,58,50,42,34,26,18, 
	10,2,59,51,43,35,27, 
	19,11,3,60,52,44,36,		 
	63,55,47,39,31,23,15, 
	7,62,54,46,38,30,22, 
	14,6,61,53,45,37,29, 
	21,13,5,28,20,12,4 
	};
	// The PC2 table for 56 bit key to 48 bit key
	int pc2[48] = { 
	14,17,11,24,1,5, 
	3,28,15,6,21,10, 
	23,19,12,4,26,8, 
	16,7,27,20,13,2, 
	41,52,31,37,47,55, 
	30,40,51,45,33,48, 
	44,49,39,56,34,53, 
	46,42,50,36,29,32 
	};
	string cipherkey="";
	for(int i=0;i<56;i++)
	{
		cipherkey=cipherkey+key[paritybox1[i]-1];
	}
	string leftkey=cipherkey.substr(0,28);
	string rightkey=cipherkey.substr(28,28);
	for(int i=0;i<16;i++)
	{
		string shiftedkeyleft;
		string shiftedkeyright;
		if(i==0 || i==1 || i==8 || i==15)
		{
			shiftedkeyleft=onebitshift(leftkey);
			shiftedkeyright=onebitshift(rightkey);
		}
		else
		{
			shiftedkeyleft=twobitshift(leftkey);
			shiftedkeyright=twobitshift(rightkey);
		}
		//for round key
		string totalshifted=shiftedkeyleft+shiftedkeyright;
		string roundkeyi="";
		for(int i=0;i<48;i++)
		{
			roundkeyi=roundkeyi+totalshifted[pc2[i]-1];
		}
		vect.push_back(roundkeyi);
		leftkey=shiftedkeyleft;
		rightkey=shiftedkeyright;
	}
}
int main()
{
	
	string plaintext;
	string keyhex;
	cin>>plaintext;
	cin>>keyhex;
	string key;
	string plaintextbin;
	plaintextbin=hexbinfunc(plaintext);
	key=hexbinfunc(keyhex);
	string strafterpermutation;
	strafterpermutation=initialpermutation(plaintextbin);
	generatekey(key);
	int getkey;
	cin>>getkey;
	string ans;
	ans=binhexfunc(vect[getkey-1]);
	cout<<ans<<" "<<plaintextbin<<endl;
	cout<<strafterpermutation<<endl;
}
