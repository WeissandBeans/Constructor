 /**
 * Author: Harrison Lee
 * Date: November 28th, 2018
 * 
 * Profile class for "Constructor" application. The profile will contain
 * meaningful user information as they use the application. This information
 * can be exported and transfered to other devices.
 */
package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Profile {
	
	private static final String INVALID_FORMAT = "Invalid File Format.";
	private static final String DELIMETER = ":";
	private static final String INTEGER_REGEX = "\\d+";
	private static final String FLOAT_REGEX = "^-?\\d*\\.{0,1}\\d+$";
	private static final String FORMAT_NAME = "#NAME";
	private static final String FORMAT_DESC = "#DESCRIPTION";
	private static final String FORMAT_PROJ_COUNT = "#PROJECTS";
	private static final String FORMAT_COMPLETED = "#COMPLETED";
	private static final String FORMAT_SAVINGS = "#SAVINGS";
	
	
	
	// Instance Fields for what a profile should contain.
	// General profile descriptors and information.
	private static String profileName;
	
	private static String profileDesc;
	
	private static int projectCount;
	
	private static int completedProjectCount;
	
	private static BigDecimal savings;
	
	// Default Constructor
	public Profile() {
		setProfileName("");
		setProfileDesc("");
		setProjectCount(0);
		setCompletedCount(0);
		setSavings(new BigDecimal(0));
	}
	
	public Profile(String profileName, String profileDesc, int projCount,
			int compProjCount, BigDecimal savings) {
		setProfileName(profileName);
		setProfileDesc(profileDesc);
		setProjectCount(projCount);
		setCompletedCount(compProjCount);
		setSavings(savings);
	}
	
	// Accessor and Mutator for profileName.
	public static String getProfileName() {
		return profileName;
	}
	
	public static void setProfileName(final String profileName) {
		Profile.profileName = profileName;
	}

	
	// Accessor and Mutator for profileDesc.
	public static String getProfileDesc() {
		return profileDesc;
	}
	
	public static void setProfileDesc(final String profileDesc) {
		Profile.profileDesc = profileDesc;
	}
	
	
	// Accessor and Mutator for projectCount.
	public static int getProjectCount() {
		return projectCount;
	}
	
	public static void setProjectCount(final int projectCount) {
		Profile.projectCount = projectCount;
	}
	
	
	// Accessor and Mutator for completedProjectCount.
	public static int getCompletedCount() {
		return completedProjectCount;
	}
	
	public static void setCompletedCount(final int compProjCount) {
		Profile.completedProjectCount = compProjCount;
	}
	
	
	// Accessor and Mutator for savings.
	public static BigDecimal getSavings() {
		return savings;
	}
	
	public static void setSavings(final BigDecimal savings) {
		Profile.savings = savings.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	
	// Method to save a user's profile. It will write the information about
	// a user's profile to a file called "save_profile.txt" and that document
	// can be loaded again to transfer user information, or default load this
	// profile on start up.
	public static void saveProfile() throws IOException {
		PrintWriter outfile = new PrintWriter(new FileWriter("save_profile.txt"));
		
		outfile.println(FORMAT_NAME + DELIMETER + getProfileName());
		outfile.println(FORMAT_DESC + DELIMETER + getProfileDesc());
		outfile.println(FORMAT_PROJ_COUNT + DELIMETER + getProjectCount());
		outfile.println(FORMAT_COMPLETED + DELIMETER + getCompletedCount());
		outfile.println(FORMAT_SAVINGS + DELIMETER + getSavings());
		
		outfile.close();
	}
	
	
	// Method to export a user's profile. It will write the information about
	// a user's profile to a file called "export_profile.txt" and that document
	// can be loaded again to transfer user information.
	public static void exportProfile() throws IOException {
		PrintWriter outfile = new PrintWriter(new FileWriter("export_profile.txt"));

		outfile.println(FORMAT_NAME + DELIMETER + getProfileName());
		outfile.println(FORMAT_DESC + DELIMETER + getProfileDesc());
		outfile.println(FORMAT_PROJ_COUNT + DELIMETER + getProjectCount());
		outfile.println(FORMAT_COMPLETED + DELIMETER + getCompletedCount());
		outfile.println(FORMAT_SAVINGS + DELIMETER + getSavings());

		outfile.close();
	}
	
	
	// Method to load a user's profile. Parse through a given text file and
	// turn information into parameters to be entered to build a user's profile
	// given the information.
	public static void loadProfile(final Scanner infile) throws IOException {
		
		String name = "";
		String description = "";
		int projCount = 0;
		int compCount = 0;
		BigDecimal tempSavings = new BigDecimal(0);
		
		while (infile.hasNextLine()) {
			final String line = infile.nextLine();
			
			if (line.startsWith(FORMAT_NAME)) {				
				name = parseString(line);
				setProfileName(name);
			} else if (line.startsWith(FORMAT_DESC)) {
				description = parseString(line);
				setProfileDesc(description);
			} else if (line.startsWith(FORMAT_PROJ_COUNT)) {
				projCount = parseInteger(line);
				setProjectCount(projCount);
			} else if (line.startsWith(FORMAT_COMPLETED)) {
				compCount = parseInteger(line);
				setCompletedCount(compCount);
			} else if (line.startsWith(FORMAT_SAVINGS)) {
				tempSavings = parseBigDecimal(line);
				setSavings(tempSavings);
			} else {
				throw new IOException();
			}
		}
	}
	
	
	// Method to help parse String objects.
	private static String parseString(final String line) throws IOException {
		final String[] parts = line.split(DELIMETER);
		if (parts.length != 2) {
			throw new IOException(INVALID_FORMAT);
		}
		return parts[1];
	}
	
	
	// Method to help parse integers.
	private static int parseInteger(final String line) throws IOException {
		final String[] parts = line.split(DELIMETER);
		if (parts.length != 2 || !parts[1].matches(INTEGER_REGEX)) {
			throw new IOException(INVALID_FORMAT);
		}
		return Integer.parseInt(parts[1]);
	}
	
	
	// Method to help parse BigDecimal objects.
	private static BigDecimal parseBigDecimal(final String theLine) throws IOException {
		final String[] parts = theLine.split(DELIMETER);
		if (parts.length != 2 || !parts[1].matches(FLOAT_REGEX)) {
			throw new IOException(INVALID_FORMAT);
		}
		BigDecimal returnVal = new BigDecimal(Double.parseDouble(parts[1]));
		return returnVal;
	}
	
	
	// toString method for developers only, mostly to aid with
	// debugging and testing.
	public String toString() {
		return "Name: " + getProfileName()
		+ "\nDescription: " + getProfileDesc()
		+ "\nProject Count: " + getProjectCount()
		+ "\nCompleted Projects: " + getCompletedCount()
		+ "\nSavings: " + getSavings();
	}
}
