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
 *  Updated : 8th of June 2009
 *  Adding comments and Announcing Open Source
 *  
 * Updated: 6th of May 2010
 * Enahancing Functionality by Amine : bakhtout@gmail.com
 *
 *
 * */
public class ArabicReshaper{
	/**
	 * The reshaped Word String
	 */
	private String _returnString = "";


	/**
	 * The Reshaped Word
	 * @return reshaped Word
	 */
	public String getReshapedWord(){

		return _returnString;
	}

	
	public static char DEFINED_CHARACTERS_ORGINAL_ALF_UPPER_MDD = 0x0622;

	
	public static char DEFINED_CHARACTERS_ORGINAL_ALF_UPPER_HAMAZA = 0x0623;

	
	public static char DEFINED_CHARACTERS_ORGINAL_ALF_LOWER_HAMAZA = 0x0625;	
	
	
	public static char DEFINED_CHARACTERS_ORGINAL_ALF = 0x0627;

	
	public static char DEFINED_CHARACTERS_ORGINAL_LAM	=0x0644;



	
	public static char[][] LAM_ALEF_GLPHIES=
	{{15270,65270,65269},
	 {15271,65272,65271},
	 {1575, 65276,65275},
	 {1573, 65274,65273}
	};

	public static char[] HARAKATE= {		
		'\u0600','\u0601','\u0602','\u0603','\u0606','\u0607','\u0608','\u0609','\u060A','\u060B','\u060D','\u060E',	
		'\u0610','\u0611','\u0612','\u0613','\u0614','\u0615','\u0616','\u0617','\u0618','\u0619','\u061A','\u061B','\u061E','\u061F',
		'\u0621',		
		'\u063B','\u063C','\u063D','\u063E','\u063F',		
		'\u0640','\u064B', '\u064C', '\u064D','\u064E', '\u064F',		
		'\u0650', '\u0651','\u0652', '\u0653', '\u0654', '\u0655', '\u0656','\u0657','\u0658','\u0659','\u065A','\u065B','\u065C','\u065D','\u065E',      
		'\u0660','\u066A','\u066B','\u066C','\u066F', '\u0670','\u0672',
		'\u06D4','\u06D5','\u06D6','\u06D7','\u06D8','\u06D9','\u06DA','\u06DB','\u06DC','\u06DF',
		'\u06E0','\u06E1','\u06E2','\u06E3','\u06E4','\u06E5','\u06E6','\u06E7','\u06E8','\u06E9','\u06EA','\u06EB','\u06EC','\u06ED','\u06EE','\u06EF',
		'\u06D6','\u06D7','\u06D8','\u06D9','\u06DA','\u06DB','\u06DC','\u06DD','\u06DE','\u06DF',
		'\u06F0','\u06FD',
		'\uFE70','\uFE71','\uFE72','\uFE73','\uFE74','\uFE75','\uFE76','\uFE77','\uFE78','\uFE79','\uFE7A','\uFE7B','\uFE7C','\uFE7D','\uFE7E','\uFE7F',
		'\uFC5E', '\uFC5F', '\uFC60','\uFC61','\uFC62','\uFC63'		
	};


	public static char[][] ARABIC_GLPHIES=
		   {{ '\u0622','\uFE81','\uFE81','\uFE82','\uFE82',2 } ,
			{ '\u0623','\uFE82','\uFE83','\uFE84','\uFE84',2 } ,
			{ '\u0624','\uFE85','\uFE85','\uFE86','\uFE86',2 } ,
			{ '\u0625','\uFE87','\uFE87','\uFE88','\uFE88',2 } ,
			{ '\u0626','\uFE89','\uFE8B','\uFE8C','\uFE8A',4 } ,
			{ '\u0627','\u0627','\u0627','\uFE8E','\uFE8E',2 } ,
			{ '\u0628','\uFE8F','\uFE91','\uFE92','\uFE90',4 } ,
			{ '\u0629','\uFE93','\uFE93','\uFE94','\uFE94',2 } ,
			{ '\u062A','\uFE95','\uFE97','\uFE98','\uFE96',4 } ,
			{ '\u062B','\uFE99','\uFE9B','\uFE9C','\uFE9A',4 } ,
			{ '\u062C','\uFE9D','\uFE9F','\uFEA0','\uFE9E',4 } ,
			{ '\u062D','\uFEA1','\uFEA3','\uFEA4','\uFEA2',4 } ,
			{ '\u062E','\uFEA5','\uFEA7','\uFEA8','\uFEA6',4 } ,
			{ '\u062F','\uFEA9','\uFEA9','\uFEAA','\uFEAA',2 } ,
			{ '\u0630','\uFEAB','\uFEAB','\uFEAC','\uFEAC',2 } ,
			{ '\u0631','\uFEAD','\uFEAD','\uFEAE','\uFEAE',2 } ,
			{ '\u0632','\uFEAF','\uFEAF','\uFEB0','\uFEB0',2 } ,
			{ '\u0633','\uFEB1','\uFEB3','\uFEB4','\uFEB2',4 } ,
			{ '\u0634','\uFEB5','\uFEB7','\uFEB8','\uFEB6',4 } ,
			{ '\u0635','\uFEB9','\uFEBB','\uFEBC','\uFEBA',4 } ,
			{ '\u0636','\uFEBD','\uFEBF','\uFEC0','\uFEBE',4 } ,
			{ '\u0637','\uFEC1','\uFEC3','\uFEC2','\uFEC4',4 } ,
			{ '\u0638','\uFEC5','\uFEC7','\uFEC6','\uFEC6',4 } ,
			{ '\u0639','\uFEC9','\uFECB','\uFECC','\uFECA',4 } ,
			{ '\u063A','\uFECD','\uFECF','\uFED0','\uFECE',4 } ,
			{ '\u0641','\uFED1','\uFED3','\uFED4','\uFED2',4 } ,
			{ '\u0642','\uFED5','\uFED7','\uFED8','\uFED6',4 } ,
			{ '\u0643','\uFED9','\uFEDB','\uFEDC','\uFEDA',4 } ,
			{ '\u0644','\uFEDD','\uFEDF','\uFEE0','\uFEDE',4 } ,
			{ '\u0645','\uFEE1','\uFEE3','\uFEE4','\uFEE2',4 } ,
			{ '\u0646','\uFEE5','\uFEE7','\uFEE8','\uFEE6',4 } ,
			{ '\u0647','\uFEE9','\uFEEB','\uFEEC','\uFEEA',4 } ,
			{ '\u0648','\uFEED','\uFEED','\uFEEE','\uFEEE',2 } ,
			{ '\u0649','\uFEEF','\uFEEF','\uFEF0','\uFEF0',2 } ,			
			{ '\u0671','\u0671','\u0671','\uFB51','\uFB51',2 },
			{ '\u064A','\uFEF1','\uFEF3','\uFEF4','\uFEF2',4 }
			};


	/**
	 * Searching for the letter and Get the right shape for the character depends on the location specified 
	 * @param target The character that needs to get its form
	 * @param location The location of the Form letter
	 * @return The letter with its right shape
	 */
	private char getReshapedGlphy(char target,int location){
		//Iterate over the 36 characters in the GLPHIES Matrix
		for(int n = 0; n<ARABIC_GLPHIES.length;n++)
		{
			//Check if the character equals the target character
			if(ARABIC_GLPHIES[n][0]==target)
			{
				//Get the right shape for the character, depends on the location
				return ARABIC_GLPHIES[n][location];
			}
		}
		//get the same character, If not found in the GLPHIES Matrix
		return target;
	}

	/**
	 * Define which Character Type is This, that has 2,3 or 4 Forms variation?
	 * @param target The character, that needed 
	 * @return the integer number indicated the Number of forms the Character has, return 2 otherwise
	 */
	private int getGlphyType(char target){
		//Iterate over the 36 characters in the GLPHIES Matrix
		for(int n = 0; n<ARABIC_GLPHIES.length;n++)
		{
			//Check if the character equals the target character
			if(ARABIC_GLPHIES[n][0]==target)
				//Get the number of Forms that the character has
				return ARABIC_GLPHIES[n][5];
		}
		//Return the number 2 Otherwise
		return 2;
	}	
	

	/**
	 * returns true if the target character is a haraka
	 * @param target
	 * @return
	 */
	private boolean isHaraka(char target) {
		
		for(int n = 0; n<HARAKATE.length;n++)
		{
			//Check if the character equals the target character
			if(HARAKATE[n]==target)
				//Get the number of Forms that the character has
				return true;
		}
		return false;
	}
	
	
	/**
	 * Get LamAlef right Character Presentation of the character
	 * @param candidateAlef The letter that is supposed to Alef
	 * @param candidateLam The letter that is supposed to Lam
	 * @param isEndOfWord Is those characters at the end of the Word, to get its right form 
	 * @return Reshaped character of the LamAlef
	 */
	private static char getLamAlef(char candidateAlef,char candidateLam,boolean isEndOfWord){
		//The shift rate, depends if the the end of the word or not!
		int shiftRate = 1;

		//The reshaped Lam Alef
		char reshapedLamAlef=0;

		//Check if at the end of the word
		if(isEndOfWord)
			shiftRate++;

		//check if the Lam is matching the candidate Lam
		if((int)DEFINED_CHARACTERS_ORGINAL_LAM ==(int)candidateLam){

			//Check which Alef is matching after the Lam and get Its form
			if((int)candidateAlef ==(int)DEFINED_CHARACTERS_ORGINAL_ALF_UPPER_MDD){
				reshapedLamAlef = LAM_ALEF_GLPHIES[0][shiftRate];
			}

			if((int)candidateAlef ==(int)DEFINED_CHARACTERS_ORGINAL_ALF_UPPER_HAMAZA){
				reshapedLamAlef = LAM_ALEF_GLPHIES[1][shiftRate];
			}

			if((int)candidateAlef ==(int)DEFINED_CHARACTERS_ORGINAL_ALF_LOWER_HAMAZA){
				reshapedLamAlef = LAM_ALEF_GLPHIES[3][shiftRate];
			}

			if((int)candidateAlef ==(int)DEFINED_CHARACTERS_ORGINAL_ALF){
				reshapedLamAlef = LAM_ALEF_GLPHIES[2][shiftRate];
			}			
			
		}
		//return the ReshapedLamAlef
		return reshapedLamAlef;
	}
	
	/**
	 * returns the position of lam-alif if found
	 * @param unshapedWord
	 * @return
	 */
	protected static int detectLamAlif(String unshapedWord) {
		int wordLength = unshapedWord.length();
		char [] wordLetters = new char[wordLength];

		//Copy the unreshapedWord to the WordLetters Character Array
		unshapedWord.getChars(0, wordLength, wordLetters,0 );
		char lamAlif = 0;
		for (int index = 0; index < unshapedWord.length() - 1 ; index++) {
			lamAlif = getLamAlef(wordLetters[index + 1], wordLetters[index], true);
			if (lamAlif != (char) 0) {
				return index;
			}
		}
		return -1; 
	}


	/**
	 * Constructor of the Class
	 * It doesn't support Alef Lam by Default
	 * @param unshapedWord The unShaped Word
	 */
	public ArabicReshaper(String unshapedWord){
		// first decompose the word
		DecomposedWord decomposedWord = new DecomposedWord(unshapedWord);
		if (ArabicReshaper.detectLamAlif(unshapedWord) < 0 && decomposedWord.stripedRegularLetters.length > 0) {
			//pass striped letters to be reshaped without tashkil
			_returnString=reshapeIt(new String(decomposedWord.stripedRegularLetters));
		} else {
			//in case teh word contains lam-alif we must trasnform it first because two letters will become one letter
			//and we would have problem while reconstructing the word.
			_returnString=reshapeItWithLamAlef(unshapedWord);
			decomposedWord = new DecomposedWord(_returnString);
			_returnString=reshapeItWithLamAlef(new String(decomposedWord.stripedRegularLetters));
		}
		_returnString = decomposedWord.reconstructWord(_returnString);
	}

	
	
	/**
	 * Decompose the word into two parts:
	 * 	- simple letters with their positions 
	 * 	- Tashkil alone with their position
	 * 
	 */
	class DecomposedWord {
		char[] stripedHarakates ;
		int[] harakatesPositions;
		char[] stripedRegularLetters;
		int[] lettersPositions;
		
		/**
		 * decompose the word
		 * @param unshapedWord
		 */
		DecomposedWord(String unshapedWord) {
			int wordLength = unshapedWord.length();
			int harakatesCount = 0;
			for(int index = 0; index < wordLength; index++ ) {
				if (isHaraka(unshapedWord.charAt(index))) {
					harakatesCount++;
				}
			}
			harakatesPositions = new int[harakatesCount];
			stripedHarakates = new char[harakatesCount];
			lettersPositions = new int[wordLength - harakatesCount];
			stripedRegularLetters = new char[wordLength - harakatesCount];
			
			harakatesCount = 0;
			int letterCount = 0;
			for(int index = 0; index < unshapedWord.length(); index++ ) {
				if (isHaraka(unshapedWord.charAt(index))) {
					harakatesPositions[harakatesCount] = index;
					stripedHarakates[harakatesCount] = unshapedWord.charAt(index);
					harakatesCount++;
				} else {
					lettersPositions[letterCount] = index;
					stripedRegularLetters[letterCount] = unshapedWord.charAt(index);
					letterCount++;
				}
			}
		}
		
		/**
		 * reconstruct the word when the reshaping ahs been done
		 * @param reshapedWord
		 * @return
		 */
		String reconstructWord(String reshapedWord) {
			char[] wordWithHarakates = null;
			wordWithHarakates = new char[reshapedWord.length() + stripedHarakates.length];
				for(int index = 0; index < lettersPositions.length; index++) {
					wordWithHarakates[lettersPositions[index]] = reshapedWord.charAt(index);
				}

				for(int index = 0; index < harakatesPositions.length; index++) {
					wordWithHarakates[harakatesPositions[index]] = stripedHarakates[index];
				}

			
			return new String(wordWithHarakates);
			
		}
	}

	/**
	 * Main Reshaping function, Doesn't Support LamAlef
	 * @param unshapedWord The unReshaped Word to Reshape
	 * @return The Reshaped Word without the LamAlef Support
	 */
	public String reshapeIt(String unshapedWord){

		//The reshaped Word to Return
		StringBuffer reshapedWord=new StringBuffer("");
		int wordLength = unshapedWord.length();		

		//The Word Letters
		char [] wordLetters = new char[wordLength];

		//Copy the unreshapedWord to the WordLetters Character Array
		unshapedWord.getChars(0, wordLength, wordLetters,0 );


		//for the first letter
		reshapedWord.append(getReshapedGlphy(wordLetters[0], 2));//2 is the Form when the Letter is at the start of the word


		//iteration from the second till the second to last
		for(int i=1;i<wordLength-1;i++){
			int beforeLast=i-1;
				//Check if the Letter Before Last has only 2 Forms, for the current Letter to be as a start for a new Word!
				if(getGlphyType(wordLetters[beforeLast])==2){ //checking if it's only has 2 shapes
					//If the letter has only 2 shapes, then it doesnt matter which position it is, It'll be always the second form
					reshapedWord.append(getReshapedGlphy(wordLetters[i], 2));
				}else {
					//Then it should be in the middle which should be placed in its right form [3]
					reshapedWord.append(getReshapedGlphy(wordLetters[i], 3));
				}
		}

		//check for the last letter Before last has 2 forms, that means that the last Letter will be alone.
		if(getGlphyType(wordLetters[wordLength-2])==2){
			//If the letter has only 2 shapes, then it doesnt matter which position it is, It'll be always the second form
			reshapedWord.append(getReshapedGlphy(wordLetters[wordLength-1], 1));
		}else {
			//Put the right form of the character, 4 for the last letter in the word
			reshapedWord.append(getReshapedGlphy(wordLetters[wordLength-1], 4));
		}		
		//Return the ReshapedWord
		return reshapedWord.toString();
	}


	

	/**
	 * Main Reshaping Function, With LamAlef Support
	 * @param unshapedWord The UnReshaped Word
	 * @return The Shaped Word with Lam Alef Support
	 */
	public String reshapeItWithLamAlef(String unshapedWord){

		//The reshaped Word to Return
		StringBuffer reshapedWord=new StringBuffer("");

		//The Word length
		int wordLength = unshapedWord.length();

		//The Word Letters
		char [] wordLetters = new char[wordLength];

		//The reshaped Letters
		char [] reshapedLetters=new char[wordLength];

		//Indicator Character, to Tell that lam is exist
		char lamIndicator=43;//The '+' 

		//Copy the unreshapedWord to the WordLetters Character Array
		unshapedWord.getChars(0, wordLength, wordLetters,0 );

		//Check if the Word Length is 0, then return empty String
		if(wordLength==0){
			return "";
		}

		//Check if the Word length is 1, then return the Reshaped One letter, which is the same character of input
		if(wordLength==1){
			return getReshapedGlphy(wordLetters[0],1)+"";
		}

		//Check if the word length is 2, Check if the Word is LamAlef 
		if(wordLength==2){
			//Assign Candidate Lam
			char lam=wordLetters[0];

			//Assign Candidate Alef
			char alef=wordLetters[1];

			//Check if The word is Lam Alef.
			if(getLamAlef(alef, lam, true)>0){
				return (char)getLamAlef(alef,lam,true)+" ";
			}

		}

		//For the First Letter
		reshapedLetters[0]=getReshapedGlphy(wordLetters[0], 2);

		//The current Letter
		char currentLetter=wordLetters[0];

		/**
		 * The Main Iterator
		 */

		//Iterate over the word from the second character till the second to the last
		for(int i=1;i<wordLength-1;i++){

			//Check if the Letters are Lam Alef
			if(getLamAlef(wordLetters[i], currentLetter, true)>0){
				//Check if the Letter before the Lam is 2 Forms Letter, to Make the Lam Alef as its the end of the Word
				if((i-2 < 0) || ((i-2 >= 0) &&  (getGlphyType(wordLetters[i-2])==2))){

					//Mark the letter of Lam as Lam Indicator
					reshapedLetters[i-1]=lamIndicator;

					//Assign Lam Alef to the Letter of Alef
					reshapedLetters[i]=(char)getLamAlef(wordLetters[i], currentLetter, true);

				}else{ //The Letter before the Lam is more than 2 Forms Letter

					//Mark the letter of Lam as Lam Indicator
					reshapedLetters[i-1]=lamIndicator;

					//Assign Lam Alef to the Letter of Alef
					reshapedLetters[i]=(char)getLamAlef(wordLetters[i], currentLetter, false);
				}
			}else{ //The Word doesn't have LamAlef

				int beforeLast=i-1;

				//Check if the Letter Before Last has only 2 Forms, for the current Letter to be as a start for a new Word!
				if(getGlphyType(wordLetters[beforeLast])==2){

					//If the letter has only 2 shapes, then it doesnt matter which position it is, It'll be always the second form
					reshapedLetters[i]=getReshapedGlphy(wordLetters[i], 2);
				}else{

					//Then it should be in the middle which should be placed in its right form [3]
					reshapedLetters[i]=getReshapedGlphy(wordLetters[i], 3);
				}
			}
			//Assign the CurrentLetter as the Word Letter
			currentLetter=wordLetters[i];
		}


		/**
		 * The Last Letters Check
		 */

		//Check if the Letters are Lam Alef
		if(getLamAlef(wordLetters[wordLength-1], wordLetters[wordLength-2], true)>0){

			//Check if the Letter before the Lam is 2 Forms Letter, to Make the Lam Alef as its the end of the Word
			if(getGlphyType(wordLetters[wordLength-3])==2){ //check for the last letter

				//Mark the letter of Lam as Lam Indicator
				reshapedLetters[wordLength-2]=lamIndicator;

				//Assign Lam Alef to the Letter of Alef
				reshapedLetters[wordLength-1]=(char)getLamAlef(wordLetters[wordLength-1], wordLetters[wordLength-2], true);
			}else {

				//Mark the letter of Lam as Lam Indicator
				reshapedLetters[wordLength-2]=lamIndicator;

				//Assign Lam Alef to the Letter of Alef
				reshapedLetters[wordLength-1]=(char)getLamAlef(wordLetters[wordLength-1], wordLetters[wordLength-2], false);
			}

		}else { 
			//check for the last letter Before last has 2 forms, that means that the last Letter will be alone.
			if(getGlphyType(wordLetters[wordLength-2])==2){
				//If the letter has only 2 shapes, then it doesn't matter which position it is, It'll be always the second form
				reshapedLetters[wordLength-1]=getReshapedGlphy(wordLetters[wordLength-1], 1);
			}else {
				//Put the right form of the character, 4 for the last letter in the word
				reshapedLetters[wordLength-1]=getReshapedGlphy(wordLetters[wordLength-1], 4);
			}
		}

		/**
		 * Assign the Final Results of Shaped Word
		 */

		//Iterate over the Reshaped Letters and remove the Lam Indicators
		for(int i=0;i<reshapedLetters.length;i++){

			//Check if the Letter is Lam Indicator
			if(reshapedLetters[i]!=lamIndicator)
				reshapedWord.append(reshapedLetters[i]);
		}

		//Return the Reshaped Word
		return reshapedWord.toString();
	}	
}