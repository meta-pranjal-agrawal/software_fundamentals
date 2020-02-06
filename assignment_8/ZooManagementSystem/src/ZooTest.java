import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ZooTest 
{
	Zoo zoo;
	
	@Before
	public void init()
	{
		zoo= new Zoo();
		zoo.addZone("mammal", 10, true, true);
		zoo.addCage("mammal", 10, "lion");
		zoo.addAnimal("mammal", "Lion", "shersingh", 8, 200);
		
	}
	
	@Test
	public void addAnimalTest()
	{
		
		boolean result=zoo.addAnimal("mammal", "Lion", "shersingh1", 10, 200);
		assertEquals(true, result);
	}
	
	@Test
	public void removeAnimalTest()
	{
		boolean result=zoo.addAnimal("mammal", "Lion", "shersingh", 8, 200);
		assertEquals(true, result);
	}
	
	@Test
	public void addZoneTest()
	{
		boolean result=zoo.addZone("bird", 10, true, true);
		assertEquals(true, result);
	}
	
	@Test 
	public void addCageTest()
	{
		boolean result=zoo.addCage("bird", 10, "tiger");
		assertEquals(false, result);
	}
	

}