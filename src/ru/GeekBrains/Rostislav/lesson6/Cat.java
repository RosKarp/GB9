package ru.GeekBrains.Rostislav.lesson6;

public class Cat extends Animal {
    protected int maxRunLength = 200;
    protected void setMaxRunLength(int maxRunLength) {
        this.maxRunLength = maxRunLength;
    }
    protected float maxJumpHeight = 2.0f;
    protected int maxSwimLength = 0;
    protected static int countOfCats = 0;
    @Override
    protected void swim(int swimLength, int maxSwimLength) {
        System.out.println("Коты и кошки не умеют плавать.");
    }
}

