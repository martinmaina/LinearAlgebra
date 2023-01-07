import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class TestLinearAlgebra {
    
    public TestLinearAlgebra() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    

     @Test
     public void testElementsInArray() {
         int expected[] = {1,2,3};
         assertArrayEquals(expected, LinearAlgebra.getElementsOfAnArray(3, "1,2,3"));
     }
     

     @Test
     public void testElementsIn4DArray() {
         int expected[] = {1,2,3,0};
         assertArrayEquals(expected, LinearAlgebra.getElementsOfAnArray4D(4, "1,2,3,0"));
     }
     
     @Test 
     public void testDotProductMethod(){
         String vectors[] = {"1,2,3", "4,5,6"};
         String vectors2[] = {"1,2","3,4"};
         assertEquals(32, LinearAlgebra.dotProduct(3, 2, vectors));
         assertEquals(11, LinearAlgebra.dotProduct(3, 2, vectors2));
     }
     
     @Test
     public void testCrossProductMethod(){
         String vectors[]={"5,-4,3","-7,2,-8"};
         assertEquals("[5, -4, 3] x [-7, 2, -8] = 26i +19j - 18k", LinearAlgebra.crossProduct(2, vectors));
     }
     
     
}
