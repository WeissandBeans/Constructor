 /**
 * Author: Harrison Lee
 * Date: November 28th, 2018
 * 
 * Profile class for "Constructor" application. The profile will contain
 * meaningful user information as they use the application. This information
 * can be exported and transfered to other devices.
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
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
	private static final String FORMAT_EMAIL = "#EMAIL";
	
	
	
	// Instance Fields for what a profile should contain.
	// General profile descriptors and information.
	private static String profileName;
	
	private static String profileDesc;
	
	private static int projectCount;
	
	private static int completedProjectCount;
	
	private static BigDecimal savings;
	
	private static ArrayList<Project> projects;
	
	private ArrayList<Project> completedProjects;
	
	private static String profileEmail;
	
	// Default Constructor
	public Profile() {
		defaultParamsLoad();
	}
	
	public Profile(String profileName, String profileDesc, int projCount,
			int compProjCount, BigDecimal savings, String profileEmail) {
		setProfileName(profileName);
		setProfileDesc(profileDesc);
		setProjectCount(projCount);
		setCompletedCount(compProjCount);
		setSavings(savings);
		setEmail(profileEmail);
	}
	
	// Accessor and Mutator for profileName.
	public static String getProfileName() {
		saveProfile();
		return profileName;
	}
	
	public static void setProfileName(final String profileName) {
		saveProfile();
		Profile.profileName = profileName;
	}

	
	// Accessor and Mutator for profileDesc.
	public static String getProfileDesc() {
		saveProfile();
		return profileDesc;
	}
	
	public static void setProfileDesc(final String profileDesc) {
		saveProfile();
		Profile.profileDesc = profileDesc;
	}
	
	
	// Accessor and Mutator for projectCount.
	public static int getProjectCount() {
		saveProfile();
		return projectCount;
	}
	
	public static void setProjectCount(final int projectCount) {
		saveProfile();
		Profile.projectCount = projectCount;
	}
	
	
	// Accessor and Mutator for completedProjectCount.
	public static int getCompletedCount() {
		saveProfile();
		return completedProjectCount;
	}
	
	public static void setCompletedCount(final int compProjCount) {
		saveProfile();
		Profile.completedProjectCount = compProjCount;
	}
	
	
	// Accessor and Mutator for savings.
	public static BigDecimal getSavings() {
		saveProfile();
		return savings;
	}
	
	public static void setSavings(final BigDecimal savings) {
		saveProfile();
		Profile.savings = savings.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	// Method to add total savings of projects.
	public static void addSavings(final BigDecimal savings) {
		saveProfile();
		Profile.savings.add(savings.setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}
	
	// Accessor and Mutator for profileName.
	public static String getEmail() {
		saveProfile();
		return profileEmail;
	}

	public static void setEmail(final String profileEmail) {
		saveProfile();
		Profile.profileName = profileEmail;
	}

	public void addProject(Project p) {
		saveProfile();
		projects.add(p);
	}
	
	public Project removeProject(Project p) {
		saveProfile();
		projects.remove(p);
		return p;
	}
	
	public ArrayList<Project> getProjects() {
		saveProfile();
		return projects;
	}
	
	public void setProjectComplete(Project p) {
		saveProfile();
		completedProjects.add(p);
		removeProject(p);
	}
	
	public Project removeCompletedProject(Project p) {
		saveProfile();
		completedProjects.remove(p);
		return p;
	}
	
	public ArrayList<Project> getCompletedProjects() {
		saveProfile();
		return completedProjects;
	}
	
	
	// Method to save a user's profile. It will write the information about
	// a user's profile to a file called "save_profile.txt" and that document
	// can be loaded again to transfer user information, or default load this
	// profile on start up.
	public static void saveProfile() {
		try {
			PrintWriter outfile = new PrintWriter(new FileWriter("save_profile.txt"));

			outfile.println(FORMAT_NAME + DELIMETER + getProfileName());
			outfile.println(FORMAT_DESC + DELIMETER + getProfileDesc());
			outfile.println(FORMAT_PROJ_COUNT + DELIMETER + getProjectCount());
			outfile.println(FORMAT_COMPLETED + DELIMETER + getCompletedCount());
			outfile.println(FORMAT_SAVINGS + DELIMETER + getSavings());
			outfile.println(FORMAT_EMAIL + DELIMETER + getEmail());
			
			for (int i = 0; i < projects.size(); i++) {
				outfile.println(projects.get(i).toString());
			}
			
			outfile.close();
		} catch (Exception e) {
			//
		}
	}
	
	
	// Method to export a user's profile. It will write the information about
	// a user's profile to a file called "export_profile.txt" and that document
	// can be loaded again to transfer user information.
	public static void exportProfile() throws IOException {
		try {
			PrintWriter outfile = new PrintWriter(
					new FileWriter(getProfileName() + "_profile.txt"));

			outfile.println(FORMAT_NAME + DELIMETER + getProfileName());
			outfile.println(FORMAT_DESC + DELIMETER + getProfileDesc());
			outfile.println(FORMAT_PROJ_COUNT + DELIMETER + getProjectCount());
			outfile.println(FORMAT_COMPLETED + DELIMETER + getCompletedCount());
			outfile.println(FORMAT_SAVINGS + DELIMETER + getSavings());
			outfile.println(FORMAT_EMAIL + DELIMETER + getEmail());
			
			for (int i = 0; i < projects.size(); i++) {
				outfile.println(projects.get(i).toString());
			}
			
			outfile.close();
		} catch (Exception e) {
			//
		}
	}
	
	// Method to load the profile header and all the projects in a single method.
	// This is mostly for usability.
	public static void loadProfile(final Scanner infile) throws IOException {
		loadProfileHeader(infile);
		loadProjects(infile);
	}
	
	// Method to load a user's profile. Parse through a given text file and
	// turn information into parameters to be entered to build a user's profile
	// given the information.
	public static void loadProfileHeader(final Scanner infile) throws IOException {
		
		String name = "";
		String description = "";
		int projCount = 0;
		int compCount = 0;
		BigDecimal tempSavings = new BigDecimal(0);
		String email = "";
		
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
			} else if (line.startsWith(FORMAT_EMAIL)) {
				email = parseString(line);
				setEmail(email);
			} else {
				throw new IOException();
			}
		}
	}
	
	// Method to parse and load projects, then add them to the arraylist of projects.
	public static void loadProjects(final Scanner infile) throws IOException {
		String tempName = "";
		String tempDesc = "";
		BigDecimal tempCost = new BigDecimal(0);
		BigDecimal tempSavings = new BigDecimal(0);
		String tempMats = "";
		int tempEnergySavings = 0;
		String tempNotes = "";
		
		while (infile.hasNextLine()) {
			final String line = infile.nextLine();
			final String[] parts = line.split(DELIMETER);
			tempName = parseString(parts[0]);
			tempDesc = parseString(parts[1]);
			tempCost = parseBigDecimal(parts[2]);
			tempSavings = parseBigDecimal(parts[3]);
			tempMats = parseString(parts[4]);
			tempEnergySavings = parseInteger(parts[5]);
			tempNotes = parseString(parts[6]);
			
			Project tempProj = new Project(tempName, tempDesc, tempCost, tempSavings,
											tempMats, tempEnergySavings, tempNotes);
			
			projects.add(tempProj);
		}
	}
	
	// Method to load "save_profile.txt" if one exists on start up. This is
	// basically loading existing settings if they exist.
	public static void loadSaveProfile() throws IOException { 
		if (new File("save_profile.txt").exists()) {
			Scanner infile = new Scanner(new File("save_profile.txt"));
			loadProfile(infile);
		} else {
			defaultParamsLoad();
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
	
	private static void defaultParamsLoad() {
		setProfileName("");
		setProfileDesc("");
		setProjectCount(0);
		setCompletedCount(0);
		setSavings(new BigDecimal(0));
		setEmail("");
	}
	
	
	// toString method for developers only, mostly to aid with
	// debugging and testing.
	public String toString() {
		return "Name: " + getProfileName()
		+ "\nDescription: " + getProfileDesc()
		+ "\nProject Count: " + getProjectCount()
		+ "\nCompleted Projects: " + getCompletedCount()
		+ "\nSavings: " + getSavings()
		+ "\nEmail: " + getEmail();
	}
}
