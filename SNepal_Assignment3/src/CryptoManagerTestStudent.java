/*
 * Class: CMSC203 CRN 32608 
 * Program: Assignment 3
 * Instructor: Professor Farnaz Eivazi 
 * Summary of Description: Junit test for CryptoManager.java
 * Due Date: 03/08/2026 11:59 P.M. 
 * Integrity Pledge: I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source.
 * Print your name here: Shuvasis Nepal 
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerTestStudent {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsStringInBoundsTrue() {
        assertTrue(CryptoManager.isStringInBounds("HELLO WORLD"));
    }

    @Test
    public void testIsStringInBoundsFalse() {
        assertFalse(CryptoManager.isStringInBounds("hello world"));
    }

    @Test
    public void testCaesarEncryption() {
        String plain = "HELLO";
        String encrypted = CryptoManager.caesarEncryption(plain, 3);
        assertNotNull(encrypted);
        assertNotEquals(plain, encrypted);
    }

    @Test
    public void testCaesarDecryption() {
        String plain = "HELLO";
        String encrypted = CryptoManager.caesarEncryption(plain, 3);
        String decrypted = CryptoManager.caesarDecryption(encrypted, 3);
        assertEquals(plain, decrypted);
    }

    @Test
    public void testCaesarOutOfBounds() {
        String result = CryptoManager.caesarEncryption("hello", 4);
        assertEquals("The selected string is not in bounds, Try again.", result);
    }

    @Test
    public void testVigenereEncryption() {
        String plain = "ATTACK AT DAWN";
        String key = "KEY";
        String encrypted = CryptoManager.vigenereEncryption(plain, key);

        assertNotNull(encrypted);
        assertNotEquals(plain, encrypted);
    }

    @Test
    public void testVigenereDecryption() {
        String plain = "ATTACK AT DAWN";
        String key = "KEY";
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);

        assertEquals(plain, decrypted);
    }

    @Test
    public void testVigenereOutOfBounds() {
        String result = CryptoManager.vigenereEncryption("attack", "KEY");
        assertEquals("The selected string is not in bounds, Try again.", result);
    }

    @Test
    public void testPlayfairEncryptionAndDecryption() {
        String plain = "HELLO";
        String key = "SECRET";
        String encrypted = CryptoManager.playfairEncryption(plain, key);
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);

        assertEquals(plain, decrypted);
    }

    @Test
    public void testPlayfairOutOfBounds() {
        String result = CryptoManager.playfairEncryption("hello", "SECRET");
        assertEquals("The selected string is not in bounds, Try again.", result);
    }
}