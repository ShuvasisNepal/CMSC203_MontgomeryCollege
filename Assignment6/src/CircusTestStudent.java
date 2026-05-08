import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CircusTestStudent {

    @Test
    public void testAddSearchAndSortAnimals() {
        Circus circus = new Circus();
        circus.addAnimal(new Dog("Zulu", 5, "Canine", "Black", "dog.png"));
        circus.addAnimal(new Bird("Alpha", 2, "Parrot", "Green", "bird.png"));
        circus.addAnimal(new Lion("Leo", 4, "Lion", "Gold", "lion.png"));

        assertEquals("Zulu", circus.searchAnimalByName("zulu").getName());
        assertNull(circus.searchAnimalByName("Missing"));

        circus.sortAnimalsByName();
        assertEquals("Alpha", circus.getAnimals().get(0).getName());

        circus.sortAnimalsByAge();
        assertEquals(2, circus.getAnimals().get(0).getAge());

        List<Animal> ageMatches = circus.searchAnimalsByAge(4);
        assertEquals(1, ageMatches.size());
        assertEquals("Leo", ageMatches.get(0).getName());
    }

    @Test
    public void testAddPersonBuildingAndTicket() {
        Circus circus = new Circus();
        circus.addPerson(new Clerk("Mary", 28, 4, "Ticket Clerk", "clerk.png"));
        circus.addBuilding(new Arena("Red", 80, 40, "arena.png"));
        circus.addTicket("Sample ticket");

        assertEquals(1, circus.getPersons().size());
        assertEquals(1, circus.getBuildings().size());
        assertEquals(1, circus.getTickets().size());
    }
}
