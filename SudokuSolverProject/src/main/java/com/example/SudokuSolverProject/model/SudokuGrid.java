package com.example.SudokuSolverProject.model;

public class SudokuGrid {
    private int[][] board;

    public SudokuGrid() {
        this.board = new int[9][9]; // Default empty board
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}
