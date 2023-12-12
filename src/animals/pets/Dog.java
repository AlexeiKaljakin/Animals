package animals.pets;

import animals.Animal;

public class Dog extends Animal {
    @Override
    public void say() {
        super.say();
        System.out.println("Гав");
    }
}
