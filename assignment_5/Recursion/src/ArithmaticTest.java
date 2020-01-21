import static org.junit.Assert.assertEquals;  
import static org.junit.Assert.*;
import org.junit.Test;

public class ArithmaticTest 
{
	@Test
	public void getLcmTest1()
	{
		Arithmatic arith= new Arithmatic();
		int lcm= arith.getLcm(4, 5);
		assertEquals(20,lcm);
	}
	
	@Test
	public void getLcmTest2()
	{
		Arithmatic arith= new Arithmatic();
		int lcm= arith.getLcm(6,8);
		assertEquals(24,lcm);
	}
	@Test
	public void getLcmTest3()
	{
		Arithmatic arith= new Arithmatic();
		int lcm= arith.getLcm(0, 5);
		assertEquals(-1,lcm);
	}
	
	@Test
	public void getHcmTest1()
	{
		Arithmatic arith= new Arithmatic();
		int hcf= arith.getHcf(7,35);
		assertEquals(7,hcf);
	}
	
	@Test
	public void getHcmTest2()
	{
		Arithmatic arith= new Arithmatic();
		int hcf= arith.getHcf(6,7);
		assertEquals(1,hcf);
	}
	
	@Test
	public void getHcmTest3()
	{
		Arithmatic arith= new Arithmatic();
		int hcf= arith.getHcf(4,0);
		assertEquals(4,hcf);
	}
}
