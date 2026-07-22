package otus;

import otus.animals.Animal;
import otus.animals.Color;
import otus.factory.AnimalFactory;
import otus.factory.AnimalType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main (String [] args){
        List<Animal> animals =new ArrayList<>();
        AnimalFactory factory = new AnimalFactory();
        Scanner scanner = new Scanner(System.in);

        Command currentCommand;
        do{
           currentCommand = askForCommand(scanner);
           if (currentCommand == Command.LIST){
               if (animals.isEmpty()){
                   System.out.println ("Список пуст");
               }
               for (Animal animal : animals){
                   System.out.println(animal.toString());
               }
           }   else if (currentCommand == Command.ADD){
               AnimalType animalType = askForAnimalType(scanner);
               Animal animal = factory.create(animalType);
               Color color = askForAnimalColor(scanner);
               animal.setColor(color);
               animal.setAge(askForAge(scanner));//вводим возраст животного, добавить остальные
               animal.setWeight(askForWeight(scanner));
               animal.setName(askForName(scanner));
               animals.add(animal);
               animal.say();
           }


        } while (currentCommand != Command.EXIT);


    }

    private static Command askForCommand(Scanner scanner){
        String input = null;
        do{
            if (input !=null){
                System.out.println("Введена неверная команда, попробуйте еще раз");
            }
            System.out.printf("Введите одну из команд (%s):", String.join ("/", Command.VALUES));
            input = scanner.next();
        }while (Command.doesNotContain(input));
        return Command.fromString(input);
    }

    private static int askForAge(Scanner scanner){
        int input = 0;
        do{
            System.out.print("Введите возраст животного");

                input = scanner.nextInt();
                if (input <= 0){
                System.out.println("Введен неверный возраст, поробуйте еще раз");
            }

        } while (input<=0);
        return input;
    }

    private static int askForWeight(Scanner scanner){ //вес
        int input = 0;
        do{
            System.out.print("Введите вес животного");

            input = scanner.nextInt();
            if (input <= 0){
                System.out.println("Введен неверный вес, поробуйте еще раз");
            }

        } while (input<=0);
        return input;
    }

    private static String askForName(Scanner scanner) {
        String input;
        do {
            System.out.print("Введите имя животного: ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Имя не может быть пустым. Пожалуйста, попробуйте еще раз.");
            }
        } while (input.isEmpty());

        return input;
    }


    private static AnimalType askForAnimalType(Scanner scanner) { //новое
        String input = null;
        do {
            if (input != null) {
                System.out.println("Введен неверный тип, попробуйте еще раз");
            }
            System.out.printf("Введите тип животного (%s):", String.join("/", AnimalType.VALUES));
            input = scanner.next();
        } while (AnimalType.doesNotContain(input));
        return AnimalType.fromString(input);
    }

    private static Color askForAnimalColor(Scanner scanner) {
        String input = null;
        do {
            if (input != null) {
                System.out.println("Введен неверный цвет, попробуйте еще раз");
            }
            System.out.printf("Введите цвет животного (%s): ", String.join("/", Color.VALUES));
            input = scanner.nextLine();
        } while (Color.doesNotContain(input));
        return Color.fromString(input);
    }

    }

