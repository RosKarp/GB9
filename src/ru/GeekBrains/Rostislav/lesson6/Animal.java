package ru.GeekBrains.Rostislav.lesson6;

public abstract class Animal {

        protected void run(int runLength, int maxRunLength) {
            if (runLength <= maxRunLength && runLength >= 0) {
                System.out.println("Run: true");
            } else
                System.out.println("Не смог добежать.");
        }
        protected void swim ( int swimLength, int maxSwimLength){
            if (swimLength <= maxSwimLength && swimLength >= 0) {
                System.out.println("Swimming: true");
            } else
                System.out.println("Не смог доплыть.");
        }
        protected void jump ( float jumpHeight, float maxJumpHeight){
            if (jumpHeight <= maxJumpHeight && jumpHeight >= 0) {
                System.out.println("Jump: true");
            } else
                System.out.println("Не смог допрыгнуть.");
        }
    }

