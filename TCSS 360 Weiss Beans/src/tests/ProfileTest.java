package tests;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;
import model.Profile;

/**
* Author: Harrison Lee
* Date: December 8th, 2018
* 
* ProfileTest class to test methods and constructor within
* Profile.java.
*/
public class ProfileTest {
	
	// Testing default constructor.
	private Profile myDefaultProfile;
	
	// Testing constructor that takes in parameters.
	private Profile myProfile;
	
	public void setUp() {
		myDefaultProfile = new Profile();
		myProfile = new Profile("Jon", "A Profile",
					new BigDecimal("1.99"), "myemail@email.com");
	}
	
	@Test
	public void testGetProfileName() {
		assertEquals("Jon", myProfile.getProfileName());
	}
	
	@Test
	public void testSetProfileName() {
		myProfile.setProfileName("noJ");
		assertEquals("noJ", myProfile.getProfileName());
	}
	
	@Test
	public void testGetProfileDesc() {
		assertEquals("A Profile", myProfile.getProfileDesc());
	}
	
	@Test
	public void testSetProfileDesc() {
		myProfile.setProfileDesc("Profile A");
		assertEquals("Profile A", myProfile.getProfileDesc());
	}
	
	@Test
	public void testGetSavings() {
		assertEquals(new BigDecimal("1.99"), myProfile.getSavings());
	}
	
	@Test
	public void testSetSavings() {
		myProfile.setSavings(new BigDecimal("2.99"));
		assertEquals(new BigDecimal("2.99"), myProfile.getSavings());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals(new BigDecimal("1.99"), myProfile.getEmail());
	}
	
	@Test
	public void testSetEmail() {
		myProfile.setEmail("emailmy@email.com");
		assertEquals("emailmy@email.com", myProfile.getEmail());
	}
}
