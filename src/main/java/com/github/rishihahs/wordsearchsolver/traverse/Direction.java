package com.github.rishihahs.wordsearchsolver.traverse;

import java.awt.Point;

/**
 * 
 * The cardinal directions used in traversing a Wordsearch puzzle
 * 
 */
public enum Direction {
    NORTH(-1, 0), 
    SOUTH(+1, 0), 
    EAST(0, +1), 
    WEST(0, -1), 
    NORTHEAST(-1, +1), 
    NORTHWEST(-1, -1), 
    SOUTHEAST(+1, +1), 
    SOUTHWEST(+1, -1);

    private final int rowChange;
    private final int colChange;

    private Direction(int rowChange, int colChange) {
        this.rowChange = rowChange;
        this.colChange = colChange;
    }

    /**
     * Updates the point according to the current direction
     * 
     * @param point The point to update
     */
    public void updatePoint(Point point) {
        point.y += rowChange;
        point.x += colChange;
    }

}