package conyersb.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonTester {

	private static Person p ;
	
	@BeforeClass
	public static void init()
	{
		p = new Person();
	}
	
	@Before
	public void beforeEveryTest()
	{
		
	}
	
	@Test
	public void a_testSetName() {
		Person p = new Person();
		p.setName("Frank");
		assertEquals("Frank", p.getName());
	}

	@Test(expected=(InvalidPersonNameException.class))
	public void a_testSetNameInvalid() {
		Person p = new Person();
		p.setName(null);
	}
}
