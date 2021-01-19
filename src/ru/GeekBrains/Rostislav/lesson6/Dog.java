package ru.GeekBrains.Rostislav.lesson6;

public class Dog extends Animal {
    protected int maxRunLength = 500;
    protected void setMaxRunLength(int maxRunLength) {
        this.maxRunLength = maxRunLength;
    }
    protected float maxJumpHeight = 0.5f;
    protected int maxSwimLength = 10;
    protected static int countOfDogs = 0;
}
