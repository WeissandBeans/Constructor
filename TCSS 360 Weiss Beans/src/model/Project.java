package model;
/*
 * TCSS 360 - Project
 */



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
	
	private Material myProjectMaterial;
	
	private int myProjectEnergySavings;
	
	private String myProjectNotes;
	
	// Project constructor, takes in project name, description, cost, savings, Materials, notes, and energy savings.
	public Project(final String theName, final String theDescription, final BigDecimal theCost, final BigDecimal theSavings, 
					final Material theMaterial, final String theNotes, final int theEnergySavings) {
		
		myProjectName = theName;
		myProjectDescription = theDescription;
		myProjectCost = theCost;
		myProjectSavings = theSavings;
		myProjectMaterial = theMaterial;
		myProjectEnergySavings = theEnergySavings;
		myProjectNotes = theNotes;
		
	}
	
	// default values
	public Project() {
		setName("");
		setDescription("");
		setCost(new BigDecimal(0));
		setSavings(new BigDecimal(0));
		setMaterials(new Material());
		setEnergySavings(0);
		setNotes("");
	}
	
	
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
	public Material getMaterial() {
		return myProjectMaterial;
	}
	
	public void setMaterials(final Material theMaterials) {
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
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (this == obj) {
			return true;
		} else if (obj == null || obj.getClass() != getClass()) {
			return false;
		} else {
			final Project prjt = (Project) obj;
			result = myProjectName.equals(prjt.myProjectName);
			result = myProjectDescription.equals(prjt.myProjectDescription);
			result = myProjectCost.equals(prjt.myProjectCost);
			result = myProjectSavings.equals(prjt.myProjectSavings);
			result = myProjectMaterial.equals(prjt.myProjectMaterial);
			result = Integer.compare(myProjectEnergySavings, prjt.myProjectEnergySavings) == 0;
			result = myProjectNotes.equals(prjt.myProjectName);
		}
		
		return result;
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