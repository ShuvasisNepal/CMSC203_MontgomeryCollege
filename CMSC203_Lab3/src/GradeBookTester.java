import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTester {

    GradeBook g1;
    GradeBook g2;
 
    @Before
    public void setUp(){

        g1 = new GradeBook(5);
        g2 = new GradeBook(5);

        g1.addScore(10);
        g1.addScore(20);
        g1.addScore(30);

        g2.addScore(40);
        g2.addScore(50);
        g2.addScore(60);
    }

    @After
    public void tearDown(){

        g1 = null;
        g2 = null;
    }

    @Test
    public void testAddScore() {

        assertTrue(g1.toString().equals("10.0 20.0 30.0 "));
        assertEquals(3, g1.getScoreSize());
    }

    @Test
    public void testSum() {

        assertEquals(60, g1.sum(), .001);
    }

    @Test
    public void testMinimum() {

        assertEquals(10, g1.minimum(), .001);
    }

    @Test
    public void testFinalScore() {

        assertEquals(50, g1.finalScore(), .001);
    }
}