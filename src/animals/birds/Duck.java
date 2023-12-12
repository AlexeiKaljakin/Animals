package animals.birds;

import animals.Animal;

public class Duck extends Animal implements IFly {
    @Override
    public void say() {
        super.say();
        System.out.println("Кря");
    }

    public void fly() {
        System.out.println("Я Лечу");
    }
}
