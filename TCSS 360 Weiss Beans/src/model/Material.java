
/*
 * TCSS 360 - Final Project
 */

package model;

import java.math.BigDecimal;

/**
 * Materials Class for team Weiss & Bean's TCSS 360 Final Project
 * @author Dustin Yoo
 * @version 1
 */

public class Material {
	
	//instance field, everything that will be needed for details of materials
	private String myMaterialName;
	
	private String myMaterialDescription;
	
	private BigDecimal myMaterialCost;
	
	private String myMaterialMeasurements;
	
	// Materials object, takes in material name, description, cost, and measurements
	public Material(String theMaterialName, String theMaterialDescription, 
					BigDecimal theMaterialCost, String theMaterialMeasurements) {
		
		myMaterialName = theMaterialName;
		myMaterialDescription = theMaterialDescription;
		myMaterialCost = theMaterialCost;
		myMaterialMeasurements = theMaterialMeasurements;
		
		}
	
	// main method to test getters & setters
//	public static void main(String[] args) {
//		Material test = new Material("wrench", "tool for project", new BigDecimal(2.9456), "12mm");
//		
//		System.out.println(test.toString());
//	}
	
	// getter & setter for material name
	public String getName() {
		return myMaterialName;
	}
	
	public void setName(String theName) {
		myMaterialName = theName;
	}
	
	// getter & setter for material description
	public String getDescription() {
		return myMaterialDescription;
	}
	
	public void setDescription(String theDescription) {
		myMaterialDescription = theDescription;
	}
	
	// getter & setter for material cost
	// returns material cost rounded half even
	public BigDecimal getCost() {
		return myMaterialCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setCost(BigDecimal theCost) {
		myMaterialCost = theCost;
	}

	// getter & setter for material measurements
	public String getMeasurements() {
		return myMaterialMeasurements;
	}
	
	public void setMeasurements(String theMeasurements) {
		myMaterialMeasurements = theMeasurements;
	}
	
	@Override
	public String toString() {
		String str = "\n********* Materials info *********";
		str += "\nMaterial Name: " + getName();
		str += "\nMaterial Description: " + getDescription();
		str += "\nMaterial Cost: " + getCost();
		str += "\nMaterial Measurements: " + getMeasurements();
		
		return str;
	}
	
}
