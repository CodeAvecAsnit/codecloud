package com.iam.high.service;

public class HighService {
    private final int target;
    private int remainingTries;
    private boolean gameOver;

    public HighService() {
        this.target = (int) (Math.random() * 100) + 1;
        this.remainingTries = 7;
        this.gameOver = false;
    }

    public Result guessNum(int guess) {
        if (gameOver) return Result.ALREADY_OVER;

        remainingTries--;

        if (guess == target) {
            gameOver = true;
            return Result.CORRECT;
        }
        if (remainingTries <= 0) {
            gameOver = true;
            return Result.OUT_OF_TRIES;
        }
        return guess < target ? Result.HIGHER : Result.LOWER;
    }


    public int getRemainingTries() {
        return remainingTries;
    }
}