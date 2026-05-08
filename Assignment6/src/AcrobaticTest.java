import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AcrobaticTest {

    @Test
    public void testConstructorAndGetters() {
        Acrobatic acrobatic = new Acrobatic("Alex", 31, 7, "Acrobat", "images/acrobat.png");
        assertEquals("Alex", acrobatic.getName());
        assertEquals(31, acrobatic.getAge());
        assertEquals(7, acrobatic.getYearsWorked());
        assertEquals("Acrobat", acrobatic.getJob());
        assertEquals("images/acrobat.png", acrobatic.getImagePath());
    }

    @Test
    public void testToString() {
        Acrobatic acrobatic = new Acrobatic("Alex", 31, 7, "Acrobat", "images/acrobat.png");
        assertEquals("Acrobatic - Name: Alex, Age: 31, Job: Acrobat, Years Worked: 7", acrobatic.toString());
    }
}
