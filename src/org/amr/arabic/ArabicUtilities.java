package org.amr.arabic;

/*
 *	Date : 14th of February 2009
 *	the class is Arabic string reshaper Utilities, this class is targeting Android platform
 *
 * 	By		: Amr Ismail Gawish
 *  E-Mail 	: amr.gawish@gmail.com
 *  Web		: http://www.amr-gawish.com
 * */

import java.util.ArrayList;

public class ArabicUtilities {


	private static final char[][] arabicGlphies=
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
	
	public static boolean isArabicCharacter(char Target)
	{
		int theResult=0;
		for(int n = 0; n<36;n++)
		{
			if(arabicGlphies[n][0]==Target)
				theResult=arabicGlphies[n][5];
		}
		
		if(theResult>0)
			return true;
		else
			return false;
	}
	
	public static String[] getWords(String text)
	{
		return text.split("\\s");
	}
	
	public static boolean checkIfWordHasArabicLetters(String word)
	{
		for(int i=0;i<word.length();i++)
		{
			if(isArabicCharacter(word.charAt(i)))
				return true;
		}
		return false;
	}
	
	public static boolean isArabicWord(String word){
		
		for(int i=0;i<word.length();i++)
		{
			if(!isArabicCharacter(word.charAt(i)))
				return false;
		}
		return true;
	}
	
	private static String[] getArabicWordsFromMixedWord(String word){
		ArrayList theResult=new ArrayList();
		String temp="";
		for(int i=0;i<word.length();i++){
			
			if(isArabicCharacter(word.charAt(i)))
			{
				temp+=word.charAt(i);
			}else{
				if(!temp.equals("")){
					theResult.add(temp);
				}
				temp="";
			} 
		}
		String[] theArabicWords=new String[theResult.size()];
		for(int i=0;i<theResult.size();i++){
			theArabicWords[i]=(String)theResult.get(i);
		}
		return theArabicWords;
	}
	
	private static String[] getWordsFromMixedWord(String word){
		ArrayList theResult=new ArrayList();
		String temp="";
		for(int i=0;i<word.length();i++){
			
			if(isArabicCharacter(word.charAt(i)))
			{
				if(!temp.equals("") && !isArabicWord(temp))
				{
					theResult.add(temp);
					temp=""+word.charAt(i);
				}else{
					temp+=word.charAt(i);
				}
					
			}else{
				if(!temp.equals("") && isArabicWord(temp)){
					theResult.add(temp);
					temp=""+word.charAt(i);
				}else{
					temp+=word.charAt(i);
				}
				
			} 
		}
		String[] theWords=new String[theResult.size()];
		for(int i=0;i<theResult.size();i++){
			theWords[i]=(String)theResult.get(i);
		}
		return theWords;
	}
	
	public static String reshape(String allText)
	{
			String[] words=getWords(allText);
			StringBuffer theResult=new StringBuffer("");
			for(int i=0;i<words.length;i++)
			{
					if(checkIfWordHasArabicLetters(words[i]))
					{
						if(isArabicWord(words[i])){
							ArabicReshaper arabicReshaper=new ArabicReshaper(words[i]);
							theResult.append(arabicReshaper.getString());
						}else{
							String [] allWords=getWordsFromMixedWord(words[i]);
							for(int j=0;j<allWords.length;j++){
								ArabicReshaper arabicReshaper=new ArabicReshaper(allWords[j]);
								theResult.append(arabicReshaper.getString());
							}
						}
						
					}else{
						theResult.append(words[i]);
					}
				
				theResult.append(" ");
			}
			return theResult.toString();
	}
}
