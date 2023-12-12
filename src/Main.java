import animals.Animal;
import animals.birds.Duck;
import animals.birds.IFly;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;

import java.util.*;

import static data.CommandsData.*;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animallist = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactory();

        while (true) {
            System.out.println("Допустимые команды: ADD, LIST, EXIT");
            String commandStr = scanner.next().toUpperCase(Locale.ROOT).trim();

            boolean isCommandExist = false;
            for (CommandsData commandsData : CommandsData.values()) {
                if (commandsData.name().equals(commandStr)) {
                    isCommandExist = true;
                    break;
                }
            }
            if (!isCommandExist) {
                System.out.println("Неверная команда");
                continue;
            }
            CommandsData commandsData = CommandsData.valueOf(commandStr);

            switch (commandsData) {
                case ADD:
                    String animalTypeStr = "";
                    while (true) {
                        System.out.println("Введите тип животного: Cat, Dog, Duck");
                        animalTypeStr = scanner.next().toUpperCase(Locale.ROOT).trim();

                        boolean isAnimalExist = false;
                        for (AnimalData animalData : AnimalData.values()) {
                            if (animalData.name().equals(animalTypeStr)) {
                                isAnimalExist = true;
                                break;
                            }
                        }
                        if (!isAnimalExist) {
                            System.out.println("Таких животных у нас нет");
                            System.out.println("Есть только: Cat, Dog, Duck");
                            continue;
                        }

                        AnimalData animalData = AnimalData.valueOf(animalTypeStr);


                        Animal animal = animalFactory.create(AnimalData.valueOf(animalTypeStr));

                        Scanner scannerName = new Scanner(System.in);
                        String name = "";
                        while (true) {
                            System.out.println("Введите имя животного");
                            name = scannerName.next();
                            if (name.matches("[А-я]+")) {
                                animal.setName(name);
                                break;
                            } else {
                                System.out.println("Принимаем только отечественные имена");
                            }
                        }

                        Scanner scannerAge = new Scanner(System.in);
                        System.out.println("Введите возраст животного");
                        int age;
                        while (true) {
                            try {
                                age = Integer.parseInt(scannerAge.nextLine());
                            } catch (Exception e) {
                                System.out.println("Введите число");
                                continue;
                            }
                            if (age <= 0) {
                                System.out.println("Животные от 1 года");
                            } else if (age >= 50) {
                                System.out.println("Животные до 50 лет");
                            } else {
                                animal.setAge(age);
                                break;
                            }
                        }


                        Scanner scannerColor = new Scanner(System.in);
                        String color = "";
                        while (true) {
                            System.out.println("Введите цвет животного");
                            color = scannerColor.next();
                            if (color.matches("[А-я]+")) {
                                animal.setColor(color);
                                break;
                            } else {
                                System.out.println("Только русские буквы");
                            }
                        }

                        Scanner scannerWeight = new Scanner(System.in);
                        System.out.println("Введите вес животного");
                        int weight;
                        while (true) {
                            try {
                                weight = Integer.parseInt(scannerAge.nextLine());
                            } catch (Exception e) {
                                System.out.println("Введите число");
                                continue;
                            }
                            if (weight < 1) {
                                System.out.println("Минимальный вес животного 1 кг");
                            } else if (weight > 50) {
                                System.out.println("Слишком толстый, максимум 50 кг");
                            } else {
                                animal.setWeight(weight);
                                break;
                            }
                        }


                        animallist.add(animal);

                        animal.say();
                        if (animal instanceof IFly) {
                            ((IFly) animal).fly();
                        }
                        System.out.println(animal.toString());

                        break;

                    }
                    break;
                case LIST:
                    if (animallist.isEmpty()) {
                        System.out.println("Записей нет");
                        continue;
                    }
                    for (Animal animal : animallist) {
                        System.out.println(animal.toString());
                    }
                    break;

                case EXIT:
                    System.exit(0);
            }
        }

    }
}

