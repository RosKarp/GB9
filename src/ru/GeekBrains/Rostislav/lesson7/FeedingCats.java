package ru.GeekBrains.Rostislav.lesson7;

import java.util.Scanner;

public class FeedingCats {

    private static final int quantityOfCats = 12;
    private static final int startAmountOfFood = 7;

    public static void main(String[] args) {
        Plate plate = new Plate(startAmountOfFood);
        plate.info();
        System.out.println();
        Cat[] cats = new Cat[quantityOfCats];
        for (int i = 0; i < quantityOfCats; i++) {
            cats[i] = new Cat("Barsik № " + (i+1), (int)(Math.random()*10), 200,0, 2.0f);
        }
        do {
             for (int i = 0; i < quantityOfCats; i++) {
                 System.out.println("Is our Barsik № " + (i + 1) + " with appetite " + cats[i].getAppetite() + " full ? : ");
                 cats[i].eat(plate);
                 System.out.println();
             }
             for (int i = 0; i < quantityOfCats; i++) {
                 if (!cats[i].getSatiety()) {
                     System.out.println();
                     System.out.println("Add food to the plate, remained hungry cats!");
                     addFood(plate);
                     break;
                 }
             }
         }
             while (Cat.countOfSatietyCats != quantityOfCats);
        System.out.println("All cats are fed!");
    }

    private static void addFood (Plate plate) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of added food: ");
        int foodCount = scanner.nextInt();
        System.out.println();
        plate.addFood(foodCount);
    }
}
