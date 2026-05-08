import java.util.ArrayList;
import java.util.List;

public class Circus {
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;
    private List<String> tickets;

    public Circus() {
        animals = new ArrayList<>();
        persons = new ArrayList<>();
        buildings = new ArrayList<>();
        tickets = new ArrayList<>();
    }


    public void addBuilding(Building building) {
        if (building != null) {
            buildings.add(building);
        }
    }

    public void displayAllBuildings() {
        if (buildings.isEmpty()) {
            System.out.println("No buildings found.");
            return;
        }

        System.out.println("All Buildings:");
        for (Building building : buildings) {
            System.out.println(building);
        }
    }

    public void addPerson(Person person) {
        if (person != null) {
            persons.add(person);
        }
    }

    public void displayAllPersons() {
        if (persons.isEmpty()) {
            System.out.println("No persons found.");
            return;
        }

        System.out.println("All Persons:");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public void addAnimal(Animal animal) {
        if (animal != null) {
            animals.add(animal);
        }
    }

    public void displayAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals found.");
            return;
        }

        System.out.println("All Animals:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public void addTicket(String ticketDetails) {
        if (ticketDetails != null && !ticketDetails.isBlank()) {
            tickets.add(ticketDetails);
        }
    }

    public void displayAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets found.");
            return;
        }

        System.out.println("All Tickets:");
        for (String ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public void sortAnimalsByAge() {
        for (int i = 0; i < animals.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(j).getAge() < animals.get(minIndex).getAge()) {
                    minIndex = j;
                }
            }

            Animal temp = animals.get(i);
            animals.set(i, animals.get(minIndex));
            animals.set(minIndex, temp);
        }
    }

    public void sortAnimalsByName() {
        for (int i = 0; i < animals.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < animals.size(); j++) {
                String currentName = animals.get(j).getName();
                String smallestName = animals.get(minIndex).getName();

                if (currentName.compareToIgnoreCase(smallestName) < 0) {
                    minIndex = j;
                }
            }

            Animal temp = animals.get(i);
            animals.set(i, animals.get(minIndex));
            animals.set(minIndex, temp);
        }
    }

    public Animal searchAnimalByName(String name) {
        if (name == null) {
            return null;
        }

        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name.trim())) {
                return animal;
            }
        }

        return null;
    }

    public List<Animal> searchAnimalsByAge(int age) {
        List<Animal> matches = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.getAge() == age) {
                matches.add(animal);
            }
        }

        return matches;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public List<String> getTickets() {
        return tickets;
    }
}
