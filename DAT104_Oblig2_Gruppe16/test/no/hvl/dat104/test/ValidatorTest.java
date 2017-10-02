package no.hvl.dat104.test;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat104.hjelpeklasser.Validator;

public class ValidatorTest {

    /*
     * A valid username should be at least 4 characters and containing
     * only letters and numbers, but not starting with a number.
     */
    @Test
    public void validFornavnLengde() {
        assertTrue(Validator.validFornavn("Abc"));
        assertTrue(Validator.validFornavn("Va"));
        assertTrue(Validator.validFornavn("Aaaaaaaaaaaaaaaaaaaa"));
    }
    @Test
    public void validFornavnTegn() {
        assertTrue(Validator.validFornavn("������"));
        assertTrue(Validator.validFornavn("A B"));
        assertTrue(Validator.validFornavn("ABC-D"));
    }
    
    @Test
    public void darligeFornavn() {
    	assertFalse(Validator.validFornavn("aaaa"));
    	assertFalse(Validator.validFornavn("A"));
    	assertFalse(Validator.validFornavn(" "));
    	assertFalse(Validator.validFornavn("Aaaaaaaaaaaaaaaaaaaaaaaa"));
    }
    
    @Test
    public void validEtternavnLengde() {
        assertTrue(Validator.validEtternavn("Abc"));
        assertTrue(Validator.validEtternavn("Va"));
        assertTrue(Validator.validEtternavn("Aaaaaaaaaaaaaaaaaaaa"));
    }
    
    @Test
    public void validEtternavnTegn() {
        assertTrue(Validator.validEtternavn("������"));
        assertTrue(Validator.validEtternavn("AB-C"));
    }
    
    @Test
    public void darligeEtternavn() {
    	   assertFalse(Validator.validEtternavn("aaaa"));
           assertFalse(Validator.validEtternavn("A"));
           assertFalse(Validator.validEtternavn(" "));
           assertFalse(Validator.validEtternavn("Aaaaaaaaaaaaaaaaaaaaaaaa"));
           assertFalse(Validator.validEtternavn("AB C"));
    }
    
    
    @Test
    public void Telefonumer() {
    	 assertTrue(Validator.validTelNum("12345678"));
    	 assertFalse(Validator.validTelNum("1a345678"));
    	 assertFalse(Validator.validTelNum("1234567"));
    	 assertFalse(Validator.validTelNum("123456789"));
    }
    
    @Test
    public void kjonn() {
    	assertTrue(Validator.validKjonn("M"));
    	assertTrue(Validator.validKjonn("F"));
    	assertFalse(Validator.validKjonn("A"));
    	assertFalse(Validator.validKjonn("MF"));
    	assertFalse(Validator.validKjonn(""));
    }
        

}
