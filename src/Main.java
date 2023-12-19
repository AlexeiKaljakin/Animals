import animals.Animal;
import animals.birds.IFly;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;

import java.util.*;
import java.util.regex.Pattern;


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

                        System.out.println("Введите имя животного");
                        String name = dataValidateStr(scannerName);
                        animal.setName(name);

                        Scanner scannerColor = new Scanner(System.in);

                        System.out.println("Введите цвет животного");
                        String color = dataValidateStr(scannerColor);
                        animal.setColor(color);

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
    private static String dataValidateStr (Scanner scanner) {
        String validateStr;
        while (true){
            validateStr = scanner.next();
            if (!validateStr.matches("^[А-я]+")) {
                System.out.println("Принимаем только русские быквы");
                continue;
            }
            break;
            }
        return validateStr;

        }

    }




