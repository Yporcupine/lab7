

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerArrayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CustomerArrayTest
{
    /**
     * Default constructor for test class CustomerArrayTest
     */
    public CustomerArrayTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void currentPositionTest(){
        Customer guy = new Customer(13,2,2);
        CustomerArray line = new CustomerArray();
        line.add(guy);
        int x = line.currentPosition();
        int y = 13;
        assertEquals(x,y);
    }
        
}
