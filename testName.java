import junit.framework.TestCase;

public class testName extends TestCase {
	private Name name;
	private String aName  = "Mark William Herbst";
	
	protected void setUp() throws Exception {
		super.setUp();
		name = new Name();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		name = null;
	}
	
	public void testGetName()
	{
		//assertEquals("Should be Mark William Herbst", "Mark William Herbst", name.getName());
	}	
	
	public void testtoString()
	{
		//assertEquals("Should be Mark William Herbst", "Mark William Herbst", name.toString());
	}
	
}
