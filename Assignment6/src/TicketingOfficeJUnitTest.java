import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicketingOfficeJUnitTest {

    @Test
    public void testConstructorAndGetters() {
        TicketingOffice office = new TicketingOffice("White", 25.0, 15.0, "images/office.png");
        assertEquals("White", office.getColor());
        assertEquals(25.0, office.getLength(), 0.001);
        assertEquals(15.0, office.getWidth(), 0.001);
        assertEquals("Ticketing Office", office.getBuildingType());
        assertEquals("images/office.png", office.getImagePath());
    }

    @Test
    public void testSetters() {
        TicketingOffice office = new TicketingOffice("White", 25.0, 15.0, "images/office.png");
        office.setColor("Yellow");
        office.setSize(30.0, 20.0);
        office.setBuildingType("Front Ticket Office");
        assertEquals("Yellow", office.getColor());
        assertEquals(30.0, office.getLength(), 0.001);
        assertEquals(20.0, office.getWidth(), 0.001);
        assertEquals("Front Ticket Office", office.getBuildingType());
    }

    @Test
    public void testToStringContainsValues() {
        TicketingOffice office = new TicketingOffice("White", 25.0, 15.0, "images/office.png");
        assertTrue(office.toString().contains("Ticketing Office"));
        assertTrue(office.toString().contains("White"));
        assertTrue(office.toString().contains("25.0 x 15.0"));
    }
}
