/*
 * TCSS 360 - Project
 */

package model;

import java.math.BigDecimal;

/**
 * Project Class for team Weiss & Bean's TCSS 360 Final Project
 * @author Dustin Yoo
 * @version 1
 */

public class Project {
	
	// Constant for splitting at ":"
	private static final String DELIMETER = ":";
	
	//instance fields, everything that will be needed for user to add to a diy project.
	private String myProjectName;
	
	private String myProjectDescription;
	
	private BigDecimal myProjectCost;
	
	private BigDecimal myProjectSavings;
	
	private String myProjectMaterial;
	
	private int myProjectEnergySavings;
	
	private String myProjectNotes;
	
	// Project constructor, takes in project name, description, cost, savings, Materials, notes, and energy savings.
	public Project(final String theName, final String theDescription, final BigDecimal theCost, final BigDecimal theSavings, 
					final String theMaterial, final int theEnergySavings, final String theNotes) {
		
		myProjectName = theName;
		myProjectDescription = theDescription;
		myProjectCost = theCost;
		myProjectSavings = theSavings;
		myProjectMaterial = theMaterial;
		myProjectEnergySavings = theEnergySavings;
		myProjectNotes = theNotes;
		
	}
	
	//main method to test getters & setters
//	public static void main(String[] args) {
//		Project test = new Project("bob", "description bob", new BigDecimal(2.9477867868678678678687), new BigDecimal(5.5555555555), new Material("tool", "mat desc", new BigDecimal(1.456), "mat measure"), "notes bob", 10);
//		
//		System.out.println(test.toString());
//	}
	
	
	//getter & setter for project name
	public String getName() {
		return myProjectName;
	}
	
	public void setName(final String theName) {
		myProjectName = theName;
	}
	
	//getter & setter for project description
	public String getDescription() {
		return myProjectDescription;
	}
	
	public void setDescription(final String theNotes) {
		myProjectDescription = theNotes;
	}
	
	
	// getter & setter for project cost
	// Returns project cost rounded half even
	public BigDecimal getCost() {
		return myProjectCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	public void setCost(final BigDecimal theCost) {
		myProjectCost = theCost;
	}
	
	
	// getter & setter for project savings
	// Returns project savings rounded half even
	public BigDecimal getSavings() {
		return myProjectSavings.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	public void setSavings(final BigDecimal theSavings) {
		myProjectSavings = theSavings;
	}
	
	
	// getter & setter for project materials
	public String getMaterial() {
		return myProjectMaterial;
	}
	
	public void setMaterials(final String theMaterials) {
		myProjectMaterial = theMaterials;
	}

	
	// getter & setter for project energy settings
	public int getEnergySavings() {
		return myProjectEnergySavings;
	}
	
	public void setEnergySavings(final int theEnergySavings) {
		myProjectEnergySavings = theEnergySavings;
	}
	
	
	// getter & setter for project notes
	public String getNotes() {
		return myProjectNotes;
	}
	
	public void setNotes(final String theNotes) {
		myProjectNotes = theNotes;
	}
	
	@Override
	public String toString() {
		return getName()
				+ DELIMETER + getDescription()
				+ DELIMETER + getCost()
				+ DELIMETER + getSavings()
				+ DELIMETER + getMaterial()
				+ DELIMETER + getEnergySavings()
				+ DELIMETER + getNotes();
	}
	
}