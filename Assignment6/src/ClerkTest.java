import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClerkTest {

    @Test
    public void testConstructorAndGetters() {
        Clerk clerk = new Clerk("Mary", 28, 4, "Ticket Clerk", "images/clerk.png");
        assertEquals("Mary", clerk.getName());
        assertEquals(28, clerk.getAge());
        assertEquals(4, clerk.getYearsWorked());
        assertEquals("Ticket Clerk", clerk.getJob());
        assertEquals("images/clerk.png", clerk.getImagePath());
    }

    @Test
    public void testToString() {
        Clerk clerk = new Clerk("Mary", 28, 4, "Ticket Clerk", "images/clerk.png");
        assertEquals("Clerk - Name: Mary, Age: 28, Job: Ticket Clerk, Years Worked: 4", clerk.toString());
    }
}
