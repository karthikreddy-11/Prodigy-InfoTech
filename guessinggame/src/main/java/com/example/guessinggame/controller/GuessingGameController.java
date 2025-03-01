package com.example.guessinggame.controller;

import com.example.guessinggame.Service.GuessingGameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/game")  // Base path for all routes
public class GuessingGameController {

    @Autowired
    private GuessingGameService gameService; // Autowired service for game logic


    @GetMapping("/")
    public String index(Model model) {
        gameService.startNewGame();
        model.addAttribute("message", "Guess a number between 1 and 100!");
        return "index";  // Load index.html
    }

    @PostMapping("/guess")
    public String guess(@RequestParam("guess") int guess, Model model) {
        String result = gameService.checkGuess(guess);
        model.addAttribute("message", result);
        return "index";
    }
}
