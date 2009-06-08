package org.amr.arabic;
/*
 *	Date : 25th of March 2008
 *	the class is Arabic string reshaper, this class is targeting Android platform
 *
 * 	By		: Ahmed Essam Naiem
 *  E-Mail 	: ahmed-essam@live.com
 *  Web		: www.ahmed-essam.com
 *  
 *  Updated Date : 20 of March 2009
 *  The class has been updated to include the Lam Alef Reshaping techniques
 *  
 *  By		: Amr Ismail gawish
 *  Email   : amr.gawish@gmail.com
 *  Web		: www.amr-gawish.com
 *  
 * */
import java.lang.String;
public class ArabicReshaper
{
	private String _returnString;
	
	public String getString(){
		
		return _returnString;
	}
	static  char DEFINED_CHARACTERS_ORGINAL_ALF_UPPER_MDD=	0x0622;
	static  char DEFINED_CHARACTERS_ORGINAL_ALF_UPPER_HAMAZA=0x0623;
	static  char DEFINED_CHARACTERS_ORGINAL_ALF_LOWER_HAMAZA=0x0625;
	static  char DEFINED_CHARACTERS_ORGINAL_ALF=0x0627;
	static  char DEFINED_CHARACTERS_ORGINAL_LAM	=0x0644;
	
	
	
	char[][] lamAlefGlphies=
	{{15270,65270,65269},
	 {15271,65272,65271},
	 {1575, 65276,65275},
	 {1573, 65274,65273}
	};
	
	char[][] arabicGlphies=
		   {{ 1569,65152,65163,65164,65152,3 } ,
			{ 1570,65153,65153,65154,65154,2 } ,
			{ 1571,65155,65155,65156,65156,2 } ,
			{ 1572,65157,65157,65158,65158,2 } ,
			{ 1573,65159,65159,65160,65160,2 } ,
			{ 1575,65165,65165,65166,65166,2 } ,
			{ 1576,65167,65169,65170,65168,4 } ,
			{ 1577,65171,65171,65172,65172,2 } ,
			{ 1578,65173,65175,65176,65174,4 } ,
			{ 1579,65177,65179,65180,65178,4 } ,
			{ 1580,65181,65183,65184,65182,4 } ,
			{ 1581,65185,65187,65188,65186,4 } ,
			{ 1582,65189,65191,65192,65190,4 } ,
			{ 1583,65193,65193,65194,65194,2 } ,
			{ 1584,65195,65195,65196,65196,2 } ,
			{ 1585,65197,65197,65198,65198,2 } ,
			{ 1586,65199,65199,65200,65200,2 } ,
			{ 1587,65201,65203,65204,65202,4 } ,
			{ 1588,65205,65207,65208,65206,4 } ,
			{ 1589,65209,65211,65212,65210,4 } ,
			{ 1590,65213,65215,65216,65214,4 } ,
			{ 1591,65217,65219,65218,65220,4 } ,
			{ 1592,65221,65223,65222,65222,4 } ,
			{ 1593,65225,65227,65228,65226,4 } ,
			{ 1594,65229,65231,65232,65230,4 } ,
			{ 1601,65233,65235,65236,65234,4 } ,
			{ 1602,65237,65239,65240,65238,4 } ,
			{ 1603,65241,65243,65244,65242,4 } ,
			{ 1604,65245,65247,65248,65246,4 } ,
			{ 1605,65249,65251,65252,65250,4 } ,
			{ 1606,65253,65255,65256,65254,4 } ,
			{ 1607,65257,65259,65260,65258,4 } ,
			{ 1608,65261,65261,65262,65262,2 } ,
			{ 1609,65263,65263,65264,65264,2 } ,
			{ 1574,65161,65161,65162,65162,2 } ,
			{ 1610,65265,65267,65268,65266,4 } };

	private char getReshapedGlphy(char target,int location)
	{
		for(int n = 0; n<36;n++)
		{
			if(arabicGlphies[n][0]==target)
			{
				return arabicGlphies[n][location];
			}
		}
		return target;
	}
	
	private int getGlphyType(char target)
	{
		for(int n = 0; n<36;n++)
		{
			if(arabicGlphies[n][0]==target)
				return arabicGlphies[n][5];
		}
		return 2;
	}
	
	private int getAlefLam(char alef,char lam,boolean isEndOfWord){
		
		int shiftRate = 0;
		char returnLetter=0;
		if(isEndOfWord)
			shiftRate = 1;
		
		if((int)DEFINED_CHARACTERS_ORGINAL_LAM==(int)lam)
		{
			System.out.println("The Lam Matches");
			if((int)alef==(int)DEFINED_CHARACTERS_ORGINAL_ALF_UPPER_MDD)
			{
				returnLetter = lamAlefGlphies[0][shiftRate+1];
			}
			if((int)alef==(int)DEFINED_CHARACTERS_ORGINAL_ALF_UPPER_HAMAZA)
			{
				returnLetter = lamAlefGlphies[1][shiftRate+1];
			}
			if((int)alef==(int)DEFINED_CHARACTERS_ORGINAL_ALF_LOWER_HAMAZA)
			{
				returnLetter = lamAlefGlphies[3][shiftRate+1];
			}
			if((int)alef==(int)DEFINED_CHARACTERS_ORGINAL_ALF)
			{
				returnLetter = lamAlefGlphies[2][shiftRate+1];
			}
		}
		return returnLetter;
	}
	
	//The initial function without alef lam
	public ArabicReshaper(String unshapedWord)
	{
		_returnString=reshapeIt(unshapedWord);
	}
	
	public String reshapeIt(String unshapedWord){
		StringBuffer returnResult=new StringBuffer("");
		int wordsLength = unshapedWord.length();
		char [] stringLetters = new char[wordsLength];
		unshapedWord.getChars(0, wordsLength, stringLetters,0 );
		
		
		//for the first letter
		returnResult.append(getReshapedGlphy(stringLetters[0], 2));
		
		
		//iteration from the second till the second to last
		for(int i=1;i<wordsLength-1;i++)
		{
			int temp=i-1;
				if(getGlphyType(stringLetters[temp])==2) //checking if it's only has 2 shapes
					returnResult.append(getReshapedGlphy(stringLetters[i], 2));
				else
					returnResult.append(getReshapedGlphy(stringLetters[i], 3));
		}
		
		
		if(getGlphyType(stringLetters[wordsLength-2])==2)//check for the last letter
		{
			returnResult.append(getReshapedGlphy(stringLetters[wordsLength-1], 1));
		}else
		{
			returnResult.append(getReshapedGlphy(stringLetters[wordsLength-1], 4));
		}
		
		return returnResult.toString();
	}
	
	public String reshapeItWithLam(String unshapedWord){
		StringBuffer returnResult=new StringBuffer("");
		int wordsLength = unshapedWord.length();
		char [] stringLetters = new char[wordsLength];
		char [] theResultString=new char[wordsLength];
		unshapedWord.getChars(0, wordsLength, stringLetters,0 );
		
		char theLastLetter=stringLetters[0];
		if(wordsLength==0){
			return "";
		}
		
		if(wordsLength==1){
			return getReshapedGlphy(stringLetters[0],1)+"";
		}
		
		if(wordsLength==2){
			char alef=stringLetters[1];
			char lam=stringLetters[0];
				
			if(getAlefLam(alef, lam, true)>0){
				return (char)getAlefLam(alef,lam,true)+" ";
			}
			
		}
		
		//For the First Letter
		theResultString[0]=getReshapedGlphy(stringLetters[0], 2);
		
		
			for(int i=1;i<wordsLength-1;i++){
				if(getAlefLam(stringLetters[i], theLastLetter, true)>0){
						if(getGlphyType(stringLetters[i-2])==2){
							theResultString[i-1]=(char)9000;
							theResultString[i]=(char)getAlefLam(stringLetters[i], theLastLetter, true);
						}else{
							theResultString[i-1]=(char)9000;
							theResultString[i]=(char)getAlefLam(stringLetters[i], theLastLetter, false);
						}
					}else{
						int temp=i-1;
						if(getGlphyType(stringLetters[temp])==2) //checking if it's only has 2 shapes
							theResultString[i]=getReshapedGlphy(stringLetters[i], 2);
						else
							theResultString[i]=getReshapedGlphy(stringLetters[i], 3);
					}
				theLastLetter=stringLetters[i];
			}
			
			/*  OLD STUFF
			//iteration from the second till the second to last
			for(int i=1;i<wordsLength-1;i++)
			{
				int temp=i-1;
					if(getGlphyType(stringLetters[temp])==2) //checking if it's only has 2 shapes
						returnResult.append(getReshapedGlphy(stringLetters[i], 2));
					else
						returnResult.append(getReshapedGlphy(stringLetters[i], 3));
			}
			
			
			*/
			
			if(getAlefLam(stringLetters[wordsLength-1], stringLetters[wordsLength-2], true)>0){
				if(getGlphyType(stringLetters[wordsLength-3])==2)//check for the last letter
				{
					theResultString[wordsLength-2]=(char)9000;
					theResultString[wordsLength-1]=(char)getAlefLam(stringLetters[wordsLength-1], stringLetters[wordsLength-2], true);
				}else {
					theResultString[wordsLength-2]=(char)9000;
					theResultString[wordsLength-1]=(char)getAlefLam(stringLetters[wordsLength-1], stringLetters[wordsLength-2], false);
				}
			}else {
				if(getGlphyType(stringLetters[wordsLength-2])==2)//check for the last letter
				{
					theResultString[wordsLength-1]=getReshapedGlphy(stringLetters[wordsLength-1], 1);
				}else {
					theResultString[wordsLength-1]=getReshapedGlphy(stringLetters[wordsLength-1], 4);
				}
			}
			returnResult=new StringBuffer("");
			for(int i=0;i<theResultString.length;i++){
				
				
				if(theResultString[i]!=(char)9000)
					returnResult.append(theResultString[i]);
			}
		return returnResult.toString();
	}
	
	
	//The Enhanced Arabic Reshaper with Lam Alef Support
	public ArabicReshaper(String unshapedWord,boolean supportAlefLam){
		if(!supportAlefLam) {
			_returnString=reshapeIt(unshapedWord);
		}else{
			_returnString=reshapeItWithLam(unshapedWord);
			}
	}
}



