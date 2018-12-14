//import static org.junit.Assert.*;
//
//import java.math.BigDecimal;
//
//import org.junit.Before;
//import org.junit.Test;
//
///**
// * Material Test Class for team Weiss & Bean's TCSS 360 Final Project
// * @author Dustin Yoo
// * @version 1
// */
//
//
//public class MaterialTest {
//	
//	private Material myDefaultMaterial;
//	
//	private Material myMaterial;
//	
//	@Before
//	public void setUp() throws Exception {
//		myDefaultMaterial = new Material();
//		
//		myMaterial = new Material("poop", "description", new BigDecimal(19.95), "measurements");
//	}
//
//	@Test
//	public void testMaterial() {
//		assertNotNull(myDefaultMaterial.getName());
//		assertNotNull(myDefaultMaterial.getDescription());
//		assertNotNull(myDefaultMaterial.getCost());
//		assertNotNull(myDefaultMaterial.getMeasurements());
//	}
//
//	@Test
//	public void testGetName() {
//		assertEquals("poop", myMaterial.getName());
//	}
//
//	@Test
//	public void testSetName() {
//		myMaterial.setName("new name");
//		
//		assertEquals("new name", myMaterial.getName());
//	}
//
//	@Test
//	public void testGetDescription() {
//		assertEquals("description", myMaterial.getDescription());
//	}
//
//	@Test
//	public void testSetDescription() {
//		myMaterial.setDescription("new description");
//		
//		assertEquals("new description", myMaterial.getDescription());
//	}
//
//	@Test
//	public void testGetCost() {
//		assertEquals(new BigDecimal(19.95).setScale(2, BigDecimal.ROUND_HALF_EVEN), myMaterial.getCost());
//	}
//
//	@Test
//	public void testSetCost() {
//		myMaterial.setCost(new BigDecimal(99.99));
//		
//		assertEquals(new BigDecimal(99.99).setScale(2, BigDecimal.ROUND_HALF_EVEN), myMaterial.getCost());
//	}
//
//	@Test
//	public void testGetMeasurements() {
//		assertEquals("measurements", myMaterial.getMeasurements());
//	}
//
//	@Test
//	public void testSetMeasurements() {
//		myMaterial.setMeasurements("new measurements");
//		
//		assertEquals("new measurements", myMaterial.getMeasurements());
//	}
//
//	@Test
//	public void testToString() {
//		assertEquals("\n********* Materials info *********\nMaterial Name: " + myMaterial.getName() + 
//					"\nMaterial Description: " + myMaterial.getDescription() + 
//					"\nMaterial Cost: " + myMaterial.getCost() + 
//					"\nMaterial Measurements: " + myMaterial.getMeasurements(), 
//					myMaterial.toString());
//		
//	}
//
//}
