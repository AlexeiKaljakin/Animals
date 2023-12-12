package animals.pets;

import animals.Animal;

public class Cat extends Animal{
    @Override
    public void say() {
        super.say();
        System.out.println("Мяу");
    }

}
