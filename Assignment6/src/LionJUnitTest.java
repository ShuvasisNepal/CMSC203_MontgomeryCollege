import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LionJUnitTest {

    @Test
    public void testConstructorAndGetters() {
        Lion lion = new Lion("Simba", 5, "African Lion", "Golden", "images/lion.png");
        assertEquals("Simba", lion.getName());
        assertEquals(5, lion.getAge());
        assertEquals("African Lion", lion.getSpecies());
        assertEquals("Golden", lion.getColor());
        assertEquals("images/lion.png", lion.getImagePath());
    }

    @Test
    public void testToString() {
        Lion lion = new Lion("Simba", 5, "African Lion", "Golden", "images/lion.png");
        assertEquals("Lion [Name: Simba, Age: 5, Species: African Lion, Color: Golden]", lion.toString());
    }
}
