import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DayOfWeekTestStudent {

    @Test
    public void testWeekdayDiscounts() {
        assertEquals(0.10, DayOfWeek.MONDAY.getDiscount(), 0.001);
        assertEquals(0.10, DayOfWeek.FRIDAY.getDiscount(), 0.001);
    }

    @Test
    public void testWeekendDiscounts() {
        assertEquals(0.0, DayOfWeek.SATURDAY.getDiscount(), 0.001);
        assertEquals(0.0, DayOfWeek.SUNDAY.getDiscount(), 0.001);
    }
}
