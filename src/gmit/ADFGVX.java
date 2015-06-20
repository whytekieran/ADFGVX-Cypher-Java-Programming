package gmit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ADFGVX 
{
	Scanner console = new Scanner(System.in);
	private final String ENCRYPTED_FILE = "Encrypted.txt";
	private final String DECRYPTED_FILE = "Decrypted.txt";
	private HashMap<Character, String> encryptValues = new HashMap<Character, String>();
	private HashMap<String, Character> tempDecryptValues = new HashMap<String, Character>();
	String codeWord;
	String fileName;
	private int totalRows;
	private String[][] encrypted;
	private Character[][] tempDecrypted;
	private Character[][] fullDecryption;
	
	//O(1) //hashmap of encryption values
    public void loadEncryptValues()
    {
    	encryptValues.put('P', "AA");
    	encryptValues.put('H', "AD");
    	encryptValues.put('0', "AF");
    	encryptValues.put('Q', "AG");
    	encryptValues.put('G', "AV");
    	encryptValues.put('6', "AX");
    	encryptValues.put('.', "AB");
    	encryptValues.put(']', "AK");
    	encryptValues.put('4', "DA");
    	encryptValues.put('M', "DD");
    	encryptValues.put('E', "DF");
    	encryptValues.put('A', "DG");
    	encryptValues.put('1', "DV");
    	encryptValues.put('Y', "DX");
    	encryptValues.put(',', "DB");
    	encryptValues.put('[', "DK");
    	encryptValues.put('L', "FA");
    	encryptValues.put('2', "FD");
    	encryptValues.put('N', "FF");
    	encryptValues.put('O', "FG");
    	encryptValues.put('F', "FV");
    	encryptValues.put('D', "FX");
    	encryptValues.put(';', "FB");
    	encryptValues.put(')', "FK");
    	encryptValues.put('X', "GA");
    	encryptValues.put('K', "GD");
    	encryptValues.put('R', "GF");
    	encryptValues.put('3', "GG");
    	encryptValues.put('C', "GV");
    	encryptValues.put('V', "GX");
    	encryptValues.put(':', "GB");
    	encryptValues.put('(', "GK");
    	encryptValues.put('S', "VA");
    	encryptValues.put('5', "VD");
    	encryptValues.put('Z', "VF");
    	encryptValues.put('W', "VG");
    	encryptValues.put('7', "VV");
    	encryptValues.put('B', "VX");
    	encryptValues.put('-', "VB");
    	encryptValues.put('_', "VK");
    	encryptValues.put('J', "XA");
    	encryptValues.put('9', "XD");
    	encryptValues.put('U', "XF");
    	encryptValues.put('T', "XG");
    	encryptValues.put('I', "XV");
    	encryptValues.put('8', "XX");
    	encryptValues.put('"', "XB");
    	encryptValues.put('*', "XK");
    	encryptValues.put('$', "BA");
    	encryptValues.put('£', "BD");
    	encryptValues.put('!', "BF");
    	encryptValues.put('&', "BG");
    	encryptValues.put('<', "BV");
    	encryptValues.put('>', "BX");
    	encryptValues.put('\'', "BB");
    	encryptValues.put('?', "BK");
    	encryptValues.put('\n', "KA");
    	encryptValues.put('\t', "KD");
    	encryptValues.put('#', "KF");
    	encryptValues.put('~', "KG");
    	encryptValues.put('^', "KV");
    	encryptValues.put('%', "KX");
    	encryptValues.put(' ', "KB");
    	encryptValues.put('É', "KK");
    }//end method
    
    //O(1) //hashmap of decryption values
    public void loadDecryptValues()
    {
    	tempDecryptValues.put("AA", 'P');
    	tempDecryptValues.put("AD", 'H');
    	tempDecryptValues.put("AF", '0');
    	tempDecryptValues.put("AG", 'Q');
    	tempDecryptValues.put("AV", 'G');
    	tempDecryptValues.put("AX", '6');
    	tempDecryptValues.put("AB", '.');
    	tempDecryptValues.put("AK", ']');
    	tempDecryptValues.put("DA", '4');
    	tempDecryptValues.put("DD", 'M');
    	tempDecryptValues.put("DF", 'E');
    	tempDecryptValues.put("DG", 'A');
    	tempDecryptValues.put("DV", '1');
    	tempDecryptValues.put("DX", 'Y');
    	tempDecryptValues.put("DB", ',');
    	tempDecryptValues.put("DK", '[');
    	tempDecryptValues.put("FA", 'L');
    	tempDecryptValues.put("FD", '2');
    	tempDecryptValues.put("FF", 'N');
    	tempDecryptValues.put("FG", 'O');
    	tempDecryptValues.put("FV", 'F');
    	tempDecryptValues.put("FX", 'D');
    	tempDecryptValues.put("FB", ';');
    	tempDecryptValues.put("FK", ')');
    	tempDecryptValues.put("GA", 'X');
    	tempDecryptValues.put("GD", 'K');
    	tempDecryptValues.put("GF", 'R');
    	tempDecryptValues.put("GG", '3');
    	tempDecryptValues.put("GV", 'C');
    	tempDecryptValues.put("GX", 'V');
    	tempDecryptValues.put("GB", ':');
    	tempDecryptValues.put("GK", '(');
    	tempDecryptValues.put("VA", 'S');
    	tempDecryptValues.put("VD", '5');
    	tempDecryptValues.put("VF", 'Z');
    	tempDecryptValues.put("VG", 'W');
    	tempDecryptValues.put("VV", '7');
    	tempDecryptValues.put("VX", 'B');
    	tempDecryptValues.put("VB", '-');
    	tempDecryptValues.put("VK", '_');
    	tempDecryptValues.put("XA", 'J');
    	tempDecryptValues.put("XD", '9');
    	tempDecryptValues.put("XF", 'U');
    	tempDecryptValues.put("XG", 'T');
    	tempDecryptValues.put("XV", 'I');
    	tempDecryptValues.put("XX", '8');
    	tempDecryptValues.put("XB", '"');
    	tempDecryptValues.put("XK", '*');
    	tempDecryptValues.put("BA", '$');
    	tempDecryptValues.put("BD", '£');
    	tempDecryptValues.put("BF", '!');
    	tempDecryptValues.put("BG", '&');
    	tempDecryptValues.put("BV", '<');
    	tempDecryptValues.put("BX", '>');
    	tempDecryptValues.put("BB", '\'');
    	tempDecryptValues.put("BK", '?');
    	tempDecryptValues.put("KA", '\n');
    	tempDecryptValues.put("KD", '\t');
    	tempDecryptValues.put("KF", '#');
    	tempDecryptValues.put("KG", '~');
    	tempDecryptValues.put("KV", '^');
    	tempDecryptValues.put("KX", '%');
    	tempDecryptValues.put("KB", ' ');
    	tempDecryptValues.put("KK", 'É');
    }//end method
    
    //ask the user for codeword and name of file 0(N)^2 nested for loop to validate codeword. Very small number of iterations always
    public void getCodeAndFileName()
    {
    	int letterCnt;
    	int i;
    	int j;
    	boolean valid = false;
    	int fileChoice;
		
    	System.out.print("Enter code word for the cypher: "); //ask for the codeword
		codeWord = console.nextLine();
		
		char[] charArray1 = codeWord.toCharArray();
		char[] charArray2 = codeWord.toCharArray();   //create two character arrays from the codeword
		
		do
		{
			for(i = 0; i < charArray1.length; ++i)
			{
				letterCnt = 0;
				
				for(j = 0; j < charArray2.length; ++j)  //check the two arrays against eachother for duplicate letters
				{
					if(charArray1[i] == charArray2[j])
					{
						++letterCnt;
						
						if(letterCnt > 1) //if more than one letter
						{
							System.out.println("Invalid Keyword - No dublicate letters!");
							System.out.println("Try Again!");
							
							System.out.println("Enter code word for the cypher: ");    //invalid input
							codeWord = console.nextLine();
							
							charArray1 = codeWord.toCharArray();
							charArray2 = codeWord.toCharArray(); //reset loop
							i = 0;
							j = 0;
							
						}
						else if((letterCnt < 2) && (i == charArray1.length - 1)) //else if only one letter and end of loop
						{
							valid = true; //true
						}
					}
				}
			}
		}
		while(valid == false);
		
		do//file menu
		{
			System.out.println();
			System.out.println(" File Menu ");
			System.out.println("1-Poblacht Na HEireann");
			System.out.println("2-De Bello Gallico");
			System.out.println("3-War and Peace");
			System.out.print("Pick a number: ");
			fileChoice = console.nextInt();
			
			if(fileChoice != 1 && fileChoice != 2 && fileChoice != 3)    //validation message
			{
				System.out.println(" Invalid Input - Try again ");
			}
		}
		while(fileChoice != 1 && fileChoice != 2 && fileChoice != 3);     
		
		switch(fileChoice) //switch the correction chosen choice
		{
			case 1:
				fileName = "PoblachtNaHEireann.txt";
				break;
			case 2:
				fileName = "DeBelloGallico.txt";           //fileName is equal to whichever choice was made
				break;
			case 3:
				fileName = "WarAndPeace-LeoTolstoy.txt";
				break;
		}
    }//end method
 
    //determine how many rows will be needed in the array O(N) loops through file and counts each character,
    //running time dependent on how many characters in the file there are. then does some constant time O(1) arithmetic
 	public void determineArrayRows()
 	{
 		@SuppressWarnings("unused")
		int c;
 		int cnt = 0;
 		
 		try
		{
			InputStream in = new FileInputStream(fileName);
			Reader reader = new InputStreamReader(in);                  //new input stream from file 
			
			
			while ((c = reader.read()) != -1) //loop through the file
			{
			    ++cnt; //count how many characters there are
			}
			
			if(cnt % codeWord.length() > 0) //divide characters by code words length and if theres a remainder
			{
				totalRows = cnt / codeWord.length();  
				totalRows += 2;   //add two extra rows, one for codeword and one for remaining characters
			}
			else //else if no remainer
			{
				totalRows = cnt / codeWord.length();
				totalRows += 1; //just one extra row for the codeword
			}
			
			in.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File could not be found");              //catch block for exceptions
		} 
		catch (IOException e) 
		{
			System.out.println("IO Problem");
		}
 	}//end method
 
 	
 	//O(N)^2 but very small amount of iterations (only codeword length) //read file and write encrypted values into 2D array O(N) 
 	//loops through entire file once, number of loops depending on how many characters there are. all operations inside kept 
 	//constant time 0(1)
 	public void readAndEncryptData()
 	{
 		try 
 		{
 			int c;
 			char fileChar;
 			int rowCnt = 0;
 			int columnCnt = 0;
 			char[] charArray = codeWord.toCharArray();
 			encrypted = new String[totalRows][codeWord.length()]; //2D array to hold encrypted values
 			InputStream in = new FileInputStream(fileName);
 			Reader reader = new InputStreamReader(in);
 			
 			for(int i = 0; i < 1; ++i)
 			{
 				for(int j = 0; j < codeWord.length(); ++j)
 				{
 					encrypted[i][j] = Character.toString(charArray[j]); //loop through the first row of array and give it the codeword
 				}
 			}
 				
 			rowCnt = 1;            //move to 2nd row and 1st column of array
 		    columnCnt = 0;
 				
 			while ((c = reader.read()) != -1) //start looping through the file
 			{
 			    fileChar = (char) c; //cast int into a char
			   
 			    if(Character.isLetter(fileChar) == true) //if its a letter
 				{
 					if(Character.isLowerCase(fileChar) == true)//if its lowercase
 					{
 						encrypted[rowCnt][columnCnt] = encryptValues.get(Character.toUpperCase(fileChar)); //convert to upper and get value for that key //pass that value into array
 				        ++columnCnt; //move to next column
 						if(columnCnt == (codeWord.length()))//if at last column
 						{
 							columnCnt = 0; //reset column
 							++rowCnt;    //increment row          
 						}
 					}
 					else //exact same without upper conversion
 					{
 						encrypted[rowCnt][columnCnt] = encryptValues.get(fileChar);
 						++columnCnt;
 						if(columnCnt == (codeWord.length()))
 						{
 							columnCnt = 0; 
 							++rowCnt;
 						}
 					}
				}
 			    else if(Character.isWhitespace(fileChar) == true) //check for whitespace
 				{
 					//whitespaces key
 					encrypted[rowCnt][columnCnt] = "KB";
 					++columnCnt;
 					if(columnCnt == (codeWord.length()))
 					{
 						columnCnt = 0; 
 						++rowCnt;
 					}
 			   }
			   else //everything other character
			   {
				    encrypted[rowCnt][columnCnt] = encryptValues.get(fileChar);
 					++columnCnt;
 					if(columnCnt == (codeWord.length()))
 					{
 						columnCnt = 0; 
 						++rowCnt;
 					}
 			   }
 			}
 		 
 			in.close();
 	    } 
 	    catch (FileNotFoundException e) 
 	    {
 		   	System.out.println("File could not be found");
 		} 
 		catch (IOException e) 
 		{
		    	System.out.println("IO Problem");
		}
 	} 	
 	
 	//O(N)^2 nested for loop but again very small amount of iterations //O(N)^2 to write encrypted characters write encrypted 
 	//array to file. all operations are 0(1)
 	public void writeEncryptedFile()
	{
		int rowCnt;
		int colCnt;
		int i;
		int j;
		String[] sortedKeyword = new String[codeWord.length()]; //array long enough to hold codeword
		
		try 
		{
			PrintWriter outFile = new PrintWriter(ENCRYPTED_FILE); //create new printwriter to encryped file
		
		    for(i = 0; i < 1; ++i)
			{
				for(j = 0; j < codeWord.length(); ++j)
				{
					sortedKeyword[j] = encrypted[i][j];     //sorted keyword gets first row of 2D encrypted values array
															//which is the codeword
				}
			}
			
			Arrays.sort(sortedKeyword); //alphabetically sort the array
			
			for(i = 0; i < codeWord.length(); ++i)
			{
				for(j = 0; j < codeWord.length(); ++j)
				{
					if(sortedKeyword[i] == encrypted[0][j]) //search for each letter of the first rows in the now sorted alpha array 
					{										//against the 2D encryped array when found...
						colCnt = j;
						
						for(rowCnt = 1; rowCnt < totalRows; ++rowCnt)//loop through that entire column
						{
							if(encrypted[rowCnt][colCnt] == null)//if null 
							{
								encrypted[rowCnt][colCnt] = "NA";//special character
								outFile.printf("%s", encrypted[rowCnt][colCnt]); //special value for null print to file
								continue;
							}
							else
							{
								outFile.printf("%s", encrypted[rowCnt][colCnt]);//print encryped value to file
							}
						}
						
						j = codeWord.length();  //after printing set j = = codeWord.length(); to end the loop
						
					}
				}
			}
			outFile.close(); //close the file
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		}
	}
 	//read encrypted characters from file and decrypt them //O(N)^2 small amount of iterations for codeword //O(N) loop through file and 
 	//decrypt all operations O(1)
 	public void readEncryptedData()
	{
		try 
		{
			int c;
			char fileChar;
			int rowCnt = 0;
			int colCnt = 0;
			int decryptCnt = 0;
			String encryptVal = "";
			tempDecrypted = new Character[totalRows][codeWord.length()];//char array for decrypted but unsorted characters
			InputStream in = new FileInputStream(ENCRYPTED_FILE);
			Reader reader = new InputStreamReader(in);
			char[] charArray = codeWord.toCharArray(); //create array containing code word
			Arrays.sort(charArray); //sort it aplhabetically
			
			for(int i = 0; i < 1; ++i)
			{
				for(int j = 0; j < codeWord.length(); ++j)
				{
					tempDecrypted[i][j] = charArray[j]; //unsorted but decryped array first row gets sorted alpha keyword
				}
			}
		
			while ((c = reader.read()) != -1) //start looping by character through file
			{
				++decryptCnt; //increment character counter
				fileChar = (char) c; //cast int to char
				
				encryptVal += Character.toString(fileChar); //string encryptedVal get converted value of char
				if(decryptCnt == 2) //if character counter is 2 means we have read two characters
				{
					++rowCnt; //increment row (row is now on index 1 if its first loop (index 0 is for the codeword))
					
					if(encryptVal == "NA") //if special null character
					{
						tempDecrypted[rowCnt][colCnt] = ' ';//just print a whitespace null only possible at end of file
					}
					else //else
					{
						Character decryptedChar = (Character) tempDecryptValues.get(encryptVal);//get char value for key
						tempDecrypted[rowCnt][colCnt] = decryptedChar; //add that char value to decrypted but unsorted arrar
			
						decryptCnt = 0; //set char counter back to zero
						encryptVal = ""; //set string for encrypt values back to blank
					}
					
					if(rowCnt == (totalRows - 1)) //if row count has reached the end of array
					{
						rowCnt = 0; //reset row
						++colCnt; // increment column
					}
				}
			}
			in.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		} 
		catch (IOException e)                            //catch blocks for exceptions
		{
			System.out.println("IO Problem");
		}
	}
 
 	//unshuffle and write decrypted data to file
 	//O(N)^2 but small iterations codeword length //O(N)^2 this time to swap the letters back to their original places
 	//0(N)^2 finally to print the deryped values back out to the decryped.txt file 
 	public void writeDecryptedData()
	{
		int i;
		int j;
		int k;
		
		try 
		{
			PrintWriter outFile = new PrintWriter(DECRYPTED_FILE);//printwriter to decrypted file
			fullDecryption = new Character[totalRows][codeWord.length() + 1]; //2D sorted and decryped array
			char[] charArray = codeWord.toCharArray();//array containing codeword
			
			for(i = 0; i < 1; ++i)
			{
				for(j = 0; j < codeWord.length(); ++j)
				{
					fullDecryption[i][j] = (Character) charArray[j]; //array 1st row get codeword
				}
			}
			
			for(i = 0; i < codeWord.length(); ++i)
			{
				for(j = 0; j < codeWord.length(); ++j)
				{
					if(fullDecryption[0][i] == tempDecrypted[0][j])//search codeword against sorted aplha codword
					{
						for(k = 1; k < totalRows; ++k)
						{
							fullDecryption[k][i] = tempDecrypted[k][j]; //print out column to full decrpted array
						}
					}
				}
			}
			
			for(i = 1; i < totalRows; ++i)
			{
				for(j = 0; j < codeWord.length(); ++j)
				{
					if(fullDecryption[i][j] == null)
					{
						continue;
					}
					else
					{
						outFile.printf("%s", fullDecryption[i][j]); //loop through the array and write to a file
					}
				}
			}
			outFile.close();
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		}
	}
 }
