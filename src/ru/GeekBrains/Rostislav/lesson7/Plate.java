package ru.GeekBrains.Rostislav.lesson7;

public class Plate {
    private int amountOfFood = 0;
    public Plate(int addedFood) {
        amountOfFood += addedFood;
    }
    public void addFood(int food) {
        amountOfFood += food;
    }
    public void info() {
        System.out.println("Food on the plate: " + amountOfFood);
    }
    public int getAmountOfFood() {
        return amountOfFood;
    }
    public void setAmountOfFood(int food) {
        amountOfFood = food;
    }
}
