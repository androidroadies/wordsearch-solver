package com.github.rishihahs.wordsearchsolver.grid;

import java.awt.Point;

/**
 * 
 * Interface for defining a grid used to store the Wordsearch puzzle in.
 * 
 */
public interface Grid {

    /**
     * Gets the letter at a certain point
     * 
     * @param point
     *            The {@link java.awt.Point} at which the letter is at
     * @return The letter
     */
    String getLetterAt(Point point);

    /**
     * Marks a letter as found
     * 
     * @param point
     *            The point of the letter that has been marked as found
     */
    void markLetterAt(Point point);

    /**
     * Checks if the given point is a valid point on the current grid
     * 
     * @param point
     *            The point to check
     * @return Whether the point is valid
     */
    boolean isValidLetter(Point point);

    /**
     * Gets the number of rows in the grid
     * 
     * @return The number of rows in the grid
     */
    int getRows();

    /**
     * Gets the number of columns in the grid
     * 
     * @return The number of columns in the grid
     */
    int getCols();

}
