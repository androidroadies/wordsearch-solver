package com.github.rishihahs.wordsearchsolver.traverse;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.github.rishihahs.wordsearchsolver.grid.Grid;

/**
 * 
 * Traverses wordsearch puzzles
 * 
 */
public class Traverse {

    private Point currentPoint = new Point(0, 0);
    private String word;
    private Direction direction;

    private List<Point> consideredPoints = new ArrayList<Point>();

    /**
     * Traverses the grid for the current word
     * 
     * @param grid The grid to traverse
     * @return Result of the operation
     */
    public boolean traverse(Grid grid) {
        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getCols(); c++) {
                for (Direction direction : Direction.values()) {
                    currentPoint.y = r;
                    currentPoint.x = c;
                    this.direction = direction;

                    if (traverse(grid, currentPoint, 0)) {
                        for (Point point : consideredPoints) {
                            grid.markLetterAt(point);
                        }

                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean traverse(Grid grid, Point point, int count) {
        if (!grid.isValidLetter(point)) {
            consideredPoints.clear();
            return false;
        }

        if (grid.getLetterAt(point).equals(word.substring(count, count + 1))) {
            consideredPoints.add(new Point(point));

            if (count == word.length() - 1) {
                return true;
            }

            direction.updatePoint(point);
            return traverse(grid, point, count + 1);
        }

        consideredPoints.clear();
        return false;
    }

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }

}
