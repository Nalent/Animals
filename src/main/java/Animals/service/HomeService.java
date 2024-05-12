package Animals.service;

import Animals.model.Animal;
import Animals.model.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    private final List<Animal> pets;
    private static List<Dog> adoptedDogs;

    public HomeService() {
        this.pets = new ArrayList<>();
        adoptedDogs = new ArrayList<>();
    }

    public int adoptPet(Animal animal) {
        if (pets.contains(animal)) {
            throw new RuntimeException(
                    "Pet is already adopted!"
            );
        }
        if(animal instanceof Dog dog){
            if(adoptedDogs.contains(dog)){
                throw new RuntimeException("This Dog already has a home!");
            }
            adoptedDogs.add(dog);
        }
        pets.add(animal);
        return pets.size();
    }

    public ArrayList<String> makeAllSounds() {
        ArrayList<String> allAnimalsSounds = new ArrayList<>();
        for (Animal pet : pets) {
            allAnimalsSounds.add(pet.sound());
        }
        return allAnimalsSounds;
    }

    public int removePet(Animal animal){
        if(!pets.contains(animal)){
            throw new IllegalArgumentException("Pet has not been adopted yet!");
        }
        pets.remove(animal);
        return pets.size();
    }
}
