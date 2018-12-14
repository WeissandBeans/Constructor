//import static org.junit.Assert.*;
//
//import java.math.BigDecimal;
//
//import org.junit.Before;
//import org.junit.Test;
//
///**
// * Project Test Class for team Weiss & Bean's TCSS 360 Final Project
// * @author Dustin Yoo
// * @version 1
// */
//
//
//public class ProjectTest {
//
//	private static final String DELIMETERTEST = ":";
//	
//	
//	private Project myProject;
//	
//	private Project myDefaultProject; 
//	
//	private Material myMaterial;
//	
//	@Before
//	public void setUp() throws Exception {
//		myDefaultProject = new Project();
//		
//		myMaterial = new Material("wrench", "tool for DIY", new BigDecimal(9.99), "10mm");
//		
//		myProject = new Project("poo", "desc", new BigDecimal(1.99), new BigDecimal(4.99), myMaterial, "notes", 2);
//	}
//
//	@Test
//	public void testProject() {
//		assertNotNull(myDefaultProject.getName());
//		assertNotNull(myDefaultProject.getDescription());
//		assertNotNull(myDefaultProject.getCost());
//		assertNotNull(myDefaultProject.getSavings());
//		assertNotNull(myDefaultProject.getMaterial());
//		assertNotNull(myDefaultProject.getNotes());
//		assertNotNull(myDefaultProject.getEnergySavings());
//	}
//
//	@Test
//	public void testGetName() {
//		assertEquals("poo", myProject.getName());
//	}
//
//	@Test
//	public void testSetName() {
//		myProject.setName("nameee");
//		
//		assertEquals("nameee", myProject.getName());
//	}
//
//	@Test
//	public void testGetDescription() {
//		assertEquals("desc", myProject.getDescription());
//	}
//
//	@Test
//	public void testSetDescription() {
//		myProject.setDescription("desc test");
//		
//		assertEquals("desc test", myProject.getDescription());
//	}
//
//	@Test
//	public void testGetCost() {
//		assertEquals(new BigDecimal(1.99).setScale(2, BigDecimal.ROUND_HALF_EVEN), myProject.getCost());
//	}
//
//	@Test
//	public void testSetCost() {
//		myProject.setCost(new BigDecimal(123.456));
//		
//		assertEquals(new BigDecimal(123.456).setScale(2, BigDecimal.ROUND_HALF_EVEN), myProject.getCost());
//	}
//
//	@Test
//	public void testGetSavings() {
//		assertEquals(new BigDecimal(4.99).setScale(2, BigDecimal.ROUND_HALF_EVEN), myProject.getSavings());
//	}
//
//	@Test
//	public void testSetSavings() {
//		myProject.setSavings(new BigDecimal(111.915));
//		
//		assertEquals(new BigDecimal(111.915).setScale(2, BigDecimal.ROUND_HALF_EVEN), myProject.getSavings());
//		
//	}
//
//	@Test
//	public void testGetMaterial() {
//		assertEquals(myMaterial, myProject.getMaterial());
//	}
//
//	@Test
//	public void testSetMaterials() {
//		myProject.setMaterials(new Material("n", "d", new BigDecimal(10.01).setScale(2, BigDecimal.ROUND_HALF_EVEN), "dd"));
//		
//		assertEquals(new Material("n", "d", new BigDecimal(10.01).setScale(2, BigDecimal.ROUND_HALF_EVEN), "dd"), myProject.getMaterial());
////		
////		Assert.AreEqual();
//	}
//
//	@Test
//	public void testGetNotes() {
//		assertEquals("notes", myProject.getNotes());
//	}
//
//	@Test
//	public void testSetNotes() {
//		myProject.setNotes("notes test");
//		
//		assertEquals("success", "notes test", myProject.getNotes());
//	}
//	
//	@Test
//	public void testGetEnergySavings() {
//		assertEquals(2, myProject.getEnergySavings());
//	}
//
//	@Test
//	public void testSetEnergySavings() {
//		myProject.setEnergySavings(777);
//		
//		assertEquals("success", 777, myProject.getEnergySavings());
//	}
//
//	@Test
//	public void testToString() {
//		assertEquals(myProject.getName() + DELIMETERTEST + 
//					 myProject.getDescription() + DELIMETERTEST + 
//					 myProject.getCost() + DELIMETERTEST + 
//					 myProject.getSavings() + DELIMETERTEST + 
//					 myProject.getMaterial() + DELIMETERTEST + 
//					 myProject.getEnergySavings() + DELIMETERTEST + 
//					 myProject.getNotes(), 
//					 myProject.toString());
//	}
//
//}
