//package tests;
//
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
//import java.math.BigDecimal;
//import model.Profile;
//
///**
//* Author: Harrison Lee
//* Date: December 8th, 2018
//* 
//* ProfileTest class to test methods and constructor within
//* Profile.java.
//*/
//public class ProfileTest {
//	
//	// Testing default constructor.
//	private static Profile myDefaultProfile;
//	
//	// Testing constructor that takes in parameters.
//	private static Profile myProfile;
//	
//	@Before
//	public void setUp() {
//		myDefaultProfile = new Profile();
//		myProfile = new Profile("Jon", "A Profile",
//					new BigDecimal("1.99"), "myemail@email.com");
//	}
//	
//	// Tests for profile name accessor and mutator.
//	@Test
//	public void testGetProfileName() {
//		assertEquals("Jon", myProfile.getProfileName());
//	}
//	
//	@Test
//	public void testSetProfileName() {
//		myProfile.setProfileName("noJ");
//		assertEquals("noJ", myProfile.getProfileName());
//	}
//	
//	// Tests for profile description accessor and mutator.
//	@Test
//	public void testGetProfileDesc() {
//		assertEquals("A Profile", myProfile.getProfileDesc());
//	}
//	
//	@Test
//	public void testSetProfileDesc() {
//		myProfile.setProfileDesc("Profile A");
//		assertEquals("Profile A", myProfile.getProfileDesc());
//	}
//	
//	// Tests for savings accessor and mutator.
//	@Test
//	public void testGetSavings() {
//		assertEquals(new BigDecimal("1.99"), myProfile.getSavings());
//	}
//	
//	@Test
//	public void testSetSavings() {
//		myProfile.setSavings(new BigDecimal("2.99"));
//		assertEquals(new BigDecimal("2.99"), myProfile.getSavings());
//	}
//	
//	// Tests for email accessor and mutator.
//	@Test
//	public void testGetEmail() {
//		assertEquals("myemail@email.com", myProfile.getEmail());
//	}
//	
//	@Test
//	public void testSetEmail() {
//		myProfile.setEmail("emailmy@email.com");
//		assertEquals("emailmy@email.com", myProfile.getEmail());
//	}
//	
//	// Test for profile toString.
//	@Test
//	public void test() {
//		assertEquals("", myProfile.toString());
//	}
//}