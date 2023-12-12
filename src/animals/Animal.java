package animals;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Animal {

    private String name;
    private int age;
    private int weight;
    private String color;


    public void say() {
        System.out.println("Я говорю: ");
    }
    public void go() {
        System.out.println("Я иду");
    }
    public void Drink() {
        System.out.println("Я пью");
    }
    public void eat() {
        System.out.println("Я ем");
    }

    public void setName(String name) {
               this.name = name;
        }

    public void setAge(int age) {
                this.age = age;
            }

    public void setWeight(int weight) {
        this.weight = weight;
        }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name = name;
    }

    public int getAge() {
        return age = age;
    }

    public int getWeight() {
        return weight = weight;
    }

    public String getColor() {
        return color = color;
    }

    @Override
    public String toString() {
        return String.format("Привет! меня зовут %s, мне %d %s, я вешу  %d кг, мой цвет - %s",
                this.name,
                this.age,
                yearCase(),
                this.weight,
                this.color
        );
    }

    private String yearCase() {

        if (this.age >= 11 && this.age <= 19) {
            return "лет";
        }

        int ostatok = this.age % 10;
        if(ostatok == 0 || ostatok >= 5){
            return "лет";
        }
        if(ostatok == 1){
            return "год";
        }
        if(ostatok >= 2){
            return "года";
        }
        return "года";
    }
}