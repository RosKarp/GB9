package ru.GeekBrains.Rostislav.lesson7;

public abstract class Animal {
    private int maxRunLength;
    private int maxSwimLength;
    private float maxJumpHeight;

        public Animal(int maxRunLength, int maxSwimLength, float maxJumpHeight) {
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
        this.maxJumpHeight = maxJumpHeight;
    }
    protected void run(int runLength, int maxRunLength) {
        if (runLength <= maxRunLength && runLength >= 0) {
            System.out.println("Run: true");
        } else
            System.out.println("He could not run.");
    }
    protected void swim ( int swimLength, int maxSwimLength){
        if (swimLength <= maxSwimLength && swimLength >= 0) {
            System.out.println("Swimming: true");
        } else
            System.out.println("He could not swim.");
    }
    protected void jump ( float jumpHeight, float maxJumpHeight){
        if (jumpHeight <= maxJumpHeight && jumpHeight >= 0) {
            System.out.println("Jump: true");
        } else
            System.out.println("He could not jump.");
    }
}
