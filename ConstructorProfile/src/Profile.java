/**
 * Author: Harrison Lee
 * Date: November 28th, 2018
 * 
 * Profile class for "Constructor" application. The profile will contain
 * meaningful user information as they use the application. This information
 * can be exported and transfered to other devices.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Profile {
	
	private static final String INVALID_FORMAT = "Invalid File Format.";
	
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
	private static String getProfileName() {
		return profileName;
	}
	
	private static void setProfileName(final String profileName) {
		Profile.profileName = profileName;
	}

	
	// Accessor and Mutator for profileDesc.
	private static String getProfileDesc() {
		return profileDesc;
	}
	
	private static void setProfileDesc(final String profileDesc) {
		Profile.profileDesc = profileDesc;
	}
	
	
	// Accessor and Mutator for projectCount.
	private static int getProjectCount() {
		return projectCount;
	}
	
	private static void setProjectCount(final int projectCount) {
		Profile.projectCount = projectCount;
	}
	
	
	// Accessor and Mutator for completedProjectCount.
	private static int getCompletedCount() {
		return completedProjectCount;
	}
	
	private static void setCompletedCount(final int compProjCount) {
		Profile.completedProjectCount = compProjCount;
	}
	
	
	// Accessor and Mutator for savings.
	private static BigDecimal getSavings() {
		return savings;
	}
	
	private static void setSavings(final BigDecimal savings) {
		Profile.savings = savings.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	
	// Method to export a user's profile. It will write the information about
	// a user's profile to a file called "user_profile".txt and that document
	// can be loaded again to transfer user information.
	private static void exportProfile() throws IOException {
		PrintWriter outfile = new PrintWriter(new FileWriter("user_profile.txt"));
		
		outfile.println("#NAME:" + getProfileName());
		outfile.println("#DESCRIPTION:" + getProfileDesc());
		outfile.println("#PROJECTS:" + getProjectCount());
		outfile.println("#COMPLETED:" + getCompletedCount());
		outfile.println("#SAVINGS:" + getSavings());
		
		outfile.close();
	}
	
	
	
	// Method to load a user's profile. Parse through a given text file and
	// turn information into parameters to be entered to build a user's profile
	// given the information.
	private static void loadProfile(final Scanner infile) throws IOException {
		
		String name = "";
		String description = "";
		int projCount = 0;
		int compCount = 0;
		BigDecimal tempSavings = new BigDecimal(0);
		
		while (infile.hasNextLine()) {
			final String line = infile.nextLine();
			
			if (line.startsWith("#NAME")) {				
				name = parseString(line);
				setProfileName(name);
			} else if (line.startsWith("#DESCRIPTION")) {
				description = parseString(line);
				setProfileDesc(description);
			} else if (line.startsWith("#PROJECTS")) {
				projCount = parseInteger(line);
				setProjectCount(projCount);
			} else if (line.startsWith("#COMPLETED")) {
				compCount = parseInteger(line);
				setCompletedCount(compCount);
			} else if (line.startsWith("#SAVINGS")) {
				tempSavings = parseBigDecimal(line);
				setSavings(tempSavings);
			} else {
				throw new IOException();
			}
		}
	}
	
	
	// Method to help parse String objects.
	private static String parseString(final String line) throws IOException {
		final String[] parts = line.split(":");
		if (parts.length != 2) {
			throw new IOException(INVALID_FORMAT);
		}
		return parts[1];
	}
	
	
	// Method to help parse integers.
	private static int parseInteger(final String line) throws IOException {
		final String[] parts = line.split(":");
		if (parts.length != 2 || !parts[1].matches("\\d+")) {
			throw new IOException(INVALID_FORMAT);
		}
		return Integer.parseInt(parts[1]);
	}
	
	
	// Method to help parse BigDecimal objects.
	private static BigDecimal parseBigDecimal(final String theLine) throws IOException {
		final String[] parts = theLine.split(":");
		if (parts.length != 2 || !parts[1].matches("^-?\\d*\\.{0,1}\\d+$")) {
			throw new IOException(INVALID_FORMAT);
		}
		BigDecimal returnVal = new BigDecimal(Double.parseDouble(parts[1]));
		return returnVal;
	}
	
	
	// toString method for developers only, mostly to aid with
	// debugging and testing.
	public String toString() {
		return "Name: " + getProfileName() + "\nDescription: " + getProfileDesc()
				+ "\nProject Count: " + getProjectCount() + "\nCompleted Projects: "
				+ getCompletedCount() + "\nSavings: " + getSavings();
	}
}
