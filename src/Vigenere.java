import java.util.Scanner;

public class Vigenere 
{
	public static final int UPPER_A = (int)'A';
	public static final int LOWER_A = (int)'a';
	public static final int UPPER_Z = (int)'Z';
	public static final int LOWER_Z = (int)'z';
	
	public static void main(String args[]) 
	{
		String plaintext;
		int plaintextLength;
		int keyLength;
		String key = "";
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is your plaintext? ");
		plaintext = in.nextLine(); 
		plaintextLength = plaintext.length();
		
		for(int i = 0, length = plaintext.length(); i < length; i++) {
			if(plaintext.charAt(i) == ' ') {
				plaintextLength--;
			}
		}
		
		keyLength = (int)(Math.random() * plaintextLength) + 1;
	
		for(int j = 0; j < keyLength; j++) {
			int asciiNum = (int)(Math.random() * (LOWER_Z - LOWER_A) + 1) + LOWER_A; 
			key += (char)asciiNum;
		}
		
		System.out.println("Key: " + key);
		System.out.print("Ciphertext: ");
		cipher(plaintext, key);
	}
	
	/* Runs the Vigenere cipher using plaintext and a key */
	
	public static void cipher(String plaintext, String key) {
		
		int keyIndex = 0;
		int keyNum = 0;
		int cipherNum = 0;
		String ciphertext = "";
		
		for(int i = 0, length = plaintext.length(); i < length; i++) {
			if(keyIndex == key.length()) {
				keyIndex = 0;
			}
			
			keyNum = (int)key.charAt(keyIndex) - LOWER_A; 
			
			if(Character.isUpperCase(plaintext.charAt(i))) {
				cipherNum = ((int)plaintext.charAt(i) + keyNum);
				
				if(cipherNum > UPPER_Z) {
					cipherNum = cipherNum % (UPPER_Z + 1) + UPPER_A;
				}
				
				ciphertext += (char)cipherNum;
				keyIndex++;
			}
			
			else if(Character.isLowerCase(plaintext.charAt(i))) {
				cipherNum = ((int)plaintext.charAt(i) + keyNum);
				
				if(cipherNum > LOWER_Z) {
					cipherNum = cipherNum % (LOWER_Z + 1) + LOWER_A;
				}
				
				ciphertext += (char)cipherNum;
				keyIndex++;
			}
			
			 else {
				ciphertext += plaintext.charAt(i);
			} 
			
		}
		
		System.out.println(ciphertext);
	}
}


