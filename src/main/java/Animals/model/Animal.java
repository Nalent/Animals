package Animals.model;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String sound();

    public String eat() {
        return this.name + " eats";
    }

}