package main;

import modelo.Sudoku;
import presentacion.SudokuInterface;

public class Main {

    public static void main(String[] args) {
        SudokuInterface sudoku = new SudokuInterface();
        sudoku.setVisible(true);        
    }
}
