import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArenaJUnitTest {

    @Test
    public void testConstructorAndGetters() {
        Arena arena = new Arena("Red", 80.0, 45.0, "images/arena.png");
        assertEquals("Red", arena.getColor());
        assertEquals(80.0, arena.getLength(), 0.001);
        assertEquals(45.0, arena.getWidth(), 0.001);
        assertEquals("Arena", arena.getBuildingType());
        assertEquals("images/arena.png", arena.getImagePath());
    }

    @Test
    public void testSetters() {
        Arena arena = new Arena("Red", 80.0, 45.0, "images/arena.png");
        arena.setColor("Blue");
        arena.setSize(100.0, 55.0);
        arena.setBuildingType("Main Arena");
        assertEquals("Blue", arena.getColor());
        assertEquals(100.0, arena.getLength(), 0.001);
        assertEquals(55.0, arena.getWidth(), 0.001);
        assertEquals("Main Arena", arena.getBuildingType());
    }

    @Test
    public void testToStringContainsValues() {
        Arena arena = new Arena("Red", 80.0, 45.0, "images/arena.png");
        assertTrue(arena.toString().contains("Arena"));
        assertTrue(arena.toString().contains("Red"));
        assertTrue(arena.toString().contains("80.0 x 45.0"));
    }
}
