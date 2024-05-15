// POO BSI (2024) - Exercicio 4

// Nome: Eduardo Ribeiro Rodrigues
// Nusp: 13696679


// Interface Animal
interface Animal {
    String getName();
    String getSpecies();
    void eat();
    void sound();
}

// Interface Ecology
interface Ecology {
    String getHabitat();
}

// Abstract class Mammal
abstract class Mammal implements Animal, Ecology {
    private String name;
    private String species;

    public Mammal(String name, String species) {    // Constructor
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void eat() {
        System.out.println("Eats like a mammal.");
    }

    public abstract void sound();

    public abstract String getHabitat();

    // Factory method to create objects of Elephant and Lion
    public static Animal get(String name, String species) {
        if (species.equalsIgnoreCase("Elephant")) {
            return new Elephant(name, species);
        } else if (species.equalsIgnoreCase("Lion")) {
            return new Lion(name, species);
        } else {
            throw new IllegalArgumentException("Unknown species");
        }
    }

}

// Class Elephant
class Elephant extends Mammal {
    public Elephant(String name, String species) {
        super(name, species);
    }

    public void sound() {
        System.out.println("Trumpets");
    }

    public String getHabitat() {
        return "Savanaah.";
    }
}

// Class Lion
class Lion extends Mammal {
    public Lion(String name, String species) {
        super(name, species);
    }

    public void sound() {
        System.out.println("Roars");
    }

    public String getHabitat() {
        return "Jungle.";
    }
}

// Class Zoo (main class)
public class Zoo {
    public static void main(String[] args) {
        Animal elephant = Mammal.get("Dumbo", "Elephant");
        Animal lion = Mammal.get("Simba", "Lion");

        System.out.println(elephant.getName());
        System.out.println(elephant.getSpecies());
        elephant.eat();
        elephant.sound();
        System.out.println(((Ecology)elephant).getHabitat());

        System.out.println(lion.getName());
        System.out.println(lion.getSpecies());
        lion.eat();
        lion.sound();
        System.out.println(((Ecology)lion).getHabitat());
    }
}
