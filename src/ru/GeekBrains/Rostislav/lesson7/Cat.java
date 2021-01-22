package ru.GeekBrains.Rostislav.lesson7;

public class Cat extends Animal {
    private String name;
    private boolean satiety = false;
    private int appetite;
    public Cat(String name, int appetite, int maxRunLength, int maxSwimLength, float maxJumpHeight){
        super(maxRunLength, maxSwimLength, maxJumpHeight);
        this.name = name;
        this.appetite = appetite;
    }
    public boolean getSatiety() {
        return satiety;
    }
    public int getAppetite() {
        return appetite;
    }
    private String checkEat(Plate plate) {
        if(appetite > plate.getAmountOfFood()) {
            return "Food is not enough in the plate.";
        }
        if(satiety){
            return "Cat is already satiety.";
        }
        return null;
    }
    public void doEat(Plate plate) {
        plate.setAmountOfFood(plate.getAmountOfFood() - appetite);
        satiety = true;
        countOfSatietyCats += 1;
        System.out.println("The Cat ate.");
    }
    public void eat(Plate plate) {
        String validateMessage = checkEat(plate);
        if(validateMessage != null) {
            System.out.println(validateMessage);
            return;
        }
        doEat(plate);
    }
    protected static int countOfSatietyCats = 0;
    @Override
    protected void swim(int swimLength, int maxSwimLength) {
        System.out.println("Cats can't swimming.");
    }
}
