package com.github.rishihahs.wordsearchsolver;

import com.github.rishihahs.wordsearchsolver.grid.Grid;
import com.github.rishihahs.wordsearchsolver.traverse.Traverse;

public class WordsearchSolver {

    private Grid grid;
    private final Traverse traverse = new Traverse();

    /**
     * Creates a WordsearchSolver with the specified grid and words to find
     * 
     * @param grid {@link Grid} to use
     */
    public WordsearchSolver(Grid grid) {
        this.grid = grid;
    }

    /**
     * Finds a word and marks the grid with its location
     * 
     * @param word The word to find
     * @return The result of the find attempt
     */
    public boolean findWord(String word) {
        traverse.setWord(word);
        return traverse.traverse(grid);
    }

    /**
     * @return the grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

}
