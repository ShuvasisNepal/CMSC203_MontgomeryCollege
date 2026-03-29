import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyTest {

    @Test
    public void testAddPropertyAndTotalRent() {
        ManagementCompany mc = new ManagementCompany("Campus Realty", "123-45-6789");
        Property p1 = new Property("Apt 1", "Rockville", 1200.0, "Bob");
        Property p2 = new Property("Apt 2", "Rockville", 1500.0, "Carol");

        int index1 = mc.addProperty(p1);
        int index2 = mc.addProperty(p2);

        assertEquals(0, index1);
        assertEquals(1, index2);
        assertEquals(2, mc.getPropertyCount());
        assertEquals(2700.0, mc.totalRent(), 0.001);
    }

    @Test
    public void testAddPropertyWhenFull() {
        ManagementCompany mc = new ManagementCompany("Campus Realty", "123-45-6789");
        for (int i = 0; i < ManagementCompany.MAX_PROPERTIES; i++) {
            mc.addProperty(new Property("P" + i, "City", 1000.0 + i, "Owner"));
        }
        int result = mc.addProperty(new Property("Extra", "City", 2000.0, "OwnerX"));
        assertEquals(-1, result);
    }

    @Test
    public void testManagementCompanyCopyConstructor() {
        ManagementCompany mc1 = new ManagementCompany("Campus Realty", "123-45-6789");
        mc1.addProperty(new Property("Apt 1", "Rockville", 1200.0, "Bob"));
        mc1.addProperty(new Property("Apt 2", "Rockville", 1500.0, "Carol"));

        ManagementCompany mc2 = new ManagementCompany(mc1);

        assertEquals(mc1.getName(), mc2.getName());
        assertEquals(mc1.getTaxId(), mc2.getTaxId());
        assertEquals(mc1.getPropertyCount(), mc2.getPropertyCount());
        assertEquals(mc1.totalRent(), mc2.totalRent(), 0.001);
        assertNotSame(mc1.getProperty(0), mc2.getProperty(0));  // deep copy
    }
    
    @Test
    public void testDefaultConstructor() {
        Property p = new Property();

        assertEquals("", p.getPropertyName());
        assertEquals("", p.getCity());
        assertEquals(0.0, p.getRentAmount(), 0.001);
        assertEquals("", p.getOwner());
    }

    @Test
    public void testParameterizedConstructor() {
        Property p = new Property("Apt 1", "Rockville", 1200.0, "Bob");

        assertEquals("Apt 1", p.getPropertyName());
        assertEquals("Rockville", p.getCity());
        assertEquals(1200.0, p.getRentAmount(), 0.001);
        assertEquals("Bob", p.getOwner());
    }

    @Test
    public void testCopyConstructor() {
        Property original = new Property("Apt 2", "Gaithersburg", 1500.0, "Carol");
        Property copy = new Property(original);

        assertEquals(original.getPropertyName(), copy.getPropertyName());
        assertEquals(original.getCity(), copy.getCity());
        assertEquals(original.getRentAmount(), copy.getRentAmount(), 0.001);
        assertEquals(original.getOwner(), copy.getOwner());
        assertNotSame(original, copy);
    }

    @Test
    public void testSettersAndGetters() {
        Property p = new Property();

        p.setPropertyName("Apt 3");
        p.setCity("Silver Spring");
        p.setRentAmount(1800.0);
        p.setOwner("David");

        assertEquals("Apt 3", p.getPropertyName());
        assertEquals("Silver Spring", p.getCity());
        assertEquals(1800.0, p.getRentAmount(), 0.001);
        assertEquals("David", p.getOwner());
    }

    @Test
    public void testToString() {
        Property p = new Property("Apt 4", "Bethesda", 2000.0, "Emma");
        String output = p.toString();

        assertTrue(output.contains("Apt 4"));
        assertTrue(output.contains("Bethesda"));
        assertTrue(output.contains("2000.0"));
        assertTrue(output.contains("Emma"));
    }
}


