package com.github.rishihahs.wordsearchsolver.grid;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Basic implementation of a grid
 * 
 */
public class BasicGrid implements Grid {

    private String[][] grid;
    private final Set<Point> markedPoints = new HashSet<Point>();

    /**
     * Creates a new BasicGrid with the supplied grid
     * 
     * @param grid The puzzle grid
     */
    public BasicGrid(String[][] grid) {
        this.grid = grid;
    }

    public String getLetterAt(Point point) {
        return grid[point.y][point.x];
    }

    public void markLetterAt(Point point) {
        markedPoints.add(point);
    }

    public boolean isValidLetter(Point point) {
        int row = point.y;
        int col = point.x;

        if (row < 0 || row > grid.length - 1) {
            return false;
        }

        if (col < 0 || col > grid[row].length - 1) {
            return false;
        }

        return true;
    }

    public int getRows() {
        return grid.length;
    }

    public int getCols() {
        return grid[0].length;
    }

    /**
     * @return the grid
     */
    public String[][] getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    /**
     * @return the markedPoints
     */
    public Set<Point> getMarkedPoints() {
        return markedPoints;
    }

}
