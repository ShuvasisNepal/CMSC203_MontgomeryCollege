/*
 * Class: CMSC203 CRN 32608 
 * Program: Assignment 3
 * Instructor: Professor Farnaz Eivazi 
 * Summary of Description: This program encrypts and decrypts a phrase using 3 approaches; Vigenere Cipher, Playfair Cipher, Caesar Cipher. 
 * Due Date: 03/08/2026 11:59 P.M. 
 * Integrity Pledge: I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source.
 * Print your name here: Shuvasis Nepal 
 */

/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   
    public static String vigenereEncryption(String plainText, String key) {
         //to be implemented by students
        if (!isStringInBounds(plainText) || !isStringInBounds(key))
            return "The selected string is not in bounds, Try again.";
        String encryption = "";
        int key_index = 0;
        for (int i = 0; i < plainText.length(); i++) {
            char p = plainText.charAt(i);
            char k = key.charAt(key_index);
            int shift = k - LOWER_RANGE;
            int newChar = p + shift;
            while (newChar > UPPER_RANGE)
                newChar = LOWER_RANGE + (newChar - UPPER_RANGE - 1);
            encryption += (char)newChar;
            key_index++;
            if (key_index == key.length())
                key_index = 0;
        }
        return encryption;
    }
    
    

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
         //to be implemented by students
        if (!isStringInBounds(encryptedText) || !isStringInBounds(key))
            return "The selected string is not in bounds, Try again.";
        String decrypted = "";
        int keyIndex = 0;
        for (int i = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            char k = key.charAt(keyIndex);
            int shift = k - LOWER_RANGE;
            int newChar = c - shift;
            while (newChar < LOWER_RANGE)
                newChar = UPPER_RANGE - (LOWER_RANGE - newChar - 1);
            decrypted += (char)newChar;
            keyIndex++;
            if (keyIndex == key.length())
                keyIndex = 0;
        }
        return decrypted;
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
    	//to be implemented by student
        if (!isStringInBounds(plainText) || !isStringInBounds(key))
            return "The selected string is not in bounds, Try again.";
        char[][] matrix = new char[8][8];
        String used = "";
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (used.indexOf(ch) == -1)
                used += ch;
        }
        for (char ch = LOWER_RANGE; ch <= UPPER_RANGE; ch++) {
            if (used.indexOf(ch) == -1)
                used += ch;
        }
        int index = 0;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                matrix[r][c] = used.charAt(index);
                index++;
            }
        }
        String prepared = "";
        int i = 0;
        while (i < plainText.length()) {
            char first = plainText.charAt(i);
            char second;
            if (i + 1 < plainText.length())
                second = plainText.charAt(i + 1);
            else
                second = 'X';

            if (first == second) {
                prepared += first;
                prepared += 'X';
                i++;
            }
            else {
                prepared += first;
                prepared += second;
                i += 2;
            }
        }
        if (prepared.length() % 2 != 0)
            prepared += "X";
        String encrypted = "";
        for (i = 0; i < prepared.length(); i += 2) {
            char a = prepared.charAt(i);
            char b = prepared.charAt(i + 1);
            int r1 = 0;
            int c1 = 0;
            int r2 = 0;
            int c2 = 0;
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    if (matrix[r][c] == a) {
                        r1 = r;
                        c1 = c;
                    }
                    if (matrix[r][c] == b) {
                        r2 = r;
                        c2 = c;
                    }
                }
            }
            if (r1 == r2) {
                encrypted += matrix[r1][(c1 + 1) % 8];
                encrypted += matrix[r2][(c2 + 1) % 8];
            }
            else if (c1 == c2) {
                encrypted += matrix[(r1 + 1) % 8][c1];
                encrypted += matrix[(r2 + 1) % 8][c2];
            }
            else {
                encrypted += matrix[r1][c2];
                encrypted += matrix[r2][c1];
            }
        }
        return encrypted;
    }

    // Playfair Decryption
    public static String playfairDecryption(String encryptedText, String key) {
        if (!isStringInBounds(encryptedText) || !isStringInBounds(key))
            return "The selected string is not in bounds, Try again.";
        char[][] matrix = new char[8][8];
        String used = "";
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (used.indexOf(ch) == -1)
                used += ch;
        }
        for (char ch = LOWER_RANGE; ch <= UPPER_RANGE; ch++) {
            if (used.indexOf(ch) == -1)
                used += ch;
        }
        int index = 0;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                matrix[r][c] = used.charAt(index);
                index++;
            }
        }
        String decrypted = "";
        for (int i = 0; i < encryptedText.length(); i += 2) {
            char a = encryptedText.charAt(i);
            char b = encryptedText.charAt(i + 1);
            int r1 = 0;
            int c1 = 0;
            int r2 = 0;
            int c2 = 0;
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    if (matrix[r][c] == a) {
                        r1 = r;
                        c1 = c;
                    }
                    if (matrix[r][c] == b) {
                        r2 = r;
                        c2 = c;
                    }
                }
            }
            if (r1 == r2) {
                decrypted += matrix[r1][(c1 + 7) % 8];
                decrypted += matrix[r2][(c2 + 7) % 8];
            }
            else if (c1 == c2) {
                decrypted += matrix[(r1 + 7) % 8][c1];
                decrypted += matrix[(r2 + 7) % 8][c2];
            }
            else {
                decrypted += matrix[r1][c2];
                decrypted += matrix[r2][c1];
            }
        }
        String cleaned = "";
        for (int i = 0; i < decrypted.length(); i++) {
            if (i > 0 && i < decrypted.length() - 1) {
                if (decrypted.charAt(i) == 'X' &&
                    decrypted.charAt(i - 1) == decrypted.charAt(i + 1)) {
                    continue;
                }
            }
            cleaned += decrypted.charAt(i);
        }
        if (cleaned.length() > 0 && cleaned.charAt(cleaned.length() - 1) == 'X')
            cleaned = cleaned.substring(0, cleaned.length() - 1);
        return cleaned;
    }
    
    
    
    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
    public static String caesarEncryption(String plainText, int key) {
	//to be implemented by students
        if (!isStringInBounds(plainText))
            return "The selected string is not in bounds, Try again.";
        String encrypted = "";
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            int newChar = ch + key;
            while (newChar > UPPER_RANGE)
                newChar = LOWER_RANGE + (newChar - UPPER_RANGE - 1);
            encrypted += (char)newChar;
        }
        return encrypted;
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
	//to be implemented by students\
        if (!isStringInBounds(encryptedText))
            return "The selected string is not in bounds, Try again.";
        String decrypted = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            int newChar = ch - key;
            while (newChar < LOWER_RANGE)
                newChar = UPPER_RANGE - (LOWER_RANGE - newChar - 1);
            decrypted += (char)newChar;
        }
        return decrypted;
    }    

}
