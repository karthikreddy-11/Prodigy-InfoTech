package com.example.guessinggame.Service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class GuessingGameService {
    private int targetNumber;
    private final Random random = new Random();

    public GuessingGameService() {
        startNewGame();  // Initialize the game when the service starts
    }

    public void startNewGame() {
        targetNumber = random.nextInt(100) + 1;  // Generate a random number (1-100)
        System.out.println("New target number: " + targetNumber);  // Debugging
    }

    public String checkGuess(int guess) {
        System.out.println("User guessed: " + guess + ", Target: " + targetNumber);  // Debugging

        if (guess < 1 || guess > 100) {
            return "Please enter a number between 1 and 100.";
        }

        if (guess < targetNumber) {
            return "Too low! Try again.";
        } else if (guess > targetNumber) {
            return "Too high! Try again.";
        } else {
            return "🎉 Correct! You guessed the number! Restarting game...";
        }
    }

    public int getTargetNumber() {
        return targetNumber;
    }
}
