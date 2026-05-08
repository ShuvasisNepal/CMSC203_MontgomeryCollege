import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BirdJUnitTest {

    @Test
    public void testConstructorAndGetters() {
        Bird bird = new Bird("Sky", 2, "Parrot", "Green", "images/bird.png");
        assertEquals("Sky", bird.getName());
        assertEquals(2, bird.getAge());
        assertEquals("Parrot", bird.getSpecies());
        assertEquals("Green", bird.getColor());
        assertEquals("images/bird.png", bird.getImagePath());
    }

    @Test
    public void testToString() {
        Bird bird = new Bird("Sky", 2, "Parrot", "Green", "images/bird.png");
        assertEquals("Bird [Name: Sky, Age: 2, Species: Parrot, Color: Green]", bird.toString());
    }
}
