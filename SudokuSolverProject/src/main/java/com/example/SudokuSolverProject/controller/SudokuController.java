package com.example.SudokuSolverProject.controller;

import com.example.SudokuSolverProject.model.SudokuGrid;
import com.example.SudokuSolverProject.service.SudokuSolverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SudokuController {
    private final SudokuSolverService sudokuSolverService;

    public SudokuController(SudokuSolverService sudokuSolverService) {
        this.sudokuSolverService = sudokuSolverService;
    }

    @GetMapping("/")
    public String showSudokuForm(Model model) {
        model.addAttribute("sudokuGrid", new SudokuGrid());
        return "index";
    }

    @PostMapping("/solve")
    public String solveSudoku(@ModelAttribute SudokuGrid sudokuGrid, Model model) {
        int[][] board = sudokuGrid.getBoard();
        boolean solved = sudokuSolverService.solveSudoku(board);

        model.addAttribute("sudokuGrid", sudokuGrid);
        model.addAttribute("solved", solved);
        return "index";
    }
}
