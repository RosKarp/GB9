package ru.GeekBrains.Rostislav.lesson6;

public class TestAnimals {

        private static final int quantityOfEachAnimal = 10;

        public static void main(String[] args) {

        Dog[] dogs = new Dog[quantityOfEachAnimal];
        Cat[] cats = new Cat[quantityOfEachAnimal];
            System.out.println("Соревнование собак и кошек начинается!");
            System.out.println();
        for (int i = 0; i < quantityOfEachAnimal; i++) {
            dogs[i] = new Dog();
            cats[i] = new Cat();
            Dog.countOfDogs += 1;
            Cat.countOfCats += 1;
            System.out.println("Результаты Dog " + (i+1) );
            dogs[i].setMaxRunLength((int)(1000 * Math.random()));  // случайная установка максимальной длины бега для конкретной собаки/кошки
            System.out.println("Максимальная длина забега Dog " + (i+1) + ": " + dogs[i].maxRunLength + " метров.");
            dogs[i].run((int)(Math.random() * 600), dogs[i].maxRunLength); // случайные параметры забега/прыжков/заплыва для собак/кошек
            dogs[i].jump((float)(Math.random() * 0.6), dogs[i].maxJumpHeight);
            dogs[i].swim((int)(Math.random() * 12), dogs[i].maxSwimLength);
            System.out.println();
            System.out.println("Результаты Cat " + (i+1) );
            cats[i].setMaxRunLength((int)(300 * Math.random()));
            System.out.println("Максимальная длина забега Cat " + (i+1) + ": " + cats[i].maxRunLength + " метров.");
            cats[i].run((int)(Math.random() * 300), cats[i].maxRunLength);
            cats[i].jump((float)(Math.random() * 2.5), cats[i].maxJumpHeight);
            cats[i].swim((int)(Math.random() * 12), cats[i].maxSwimLength);
            System.out.println();
            System.out.println("Создано " + Dog.countOfDogs + " собак и " + Cat.countOfCats + " котов."); // вывод количества созданных животных из их классов
            System.out.println();
        }
    }
 }
