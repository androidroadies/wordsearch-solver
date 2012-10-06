package com.github.rishihahs.wordsearchsolver.traverse;

import static com.github.rishihahs.wordsearchsolver.Puzzle.GRID;
import static com.github.rishihahs.wordsearchsolver.Puzzle.WORDS;
import static org.junit.Assert.assertArrayEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.github.rishihahs.wordsearchsolver.grid.Grid;

public class TraverseTest {
    
    private Traverse traverse;

    @Before
    public void setUp() throws Exception {
        traverse = new Traverse();
    }

    @Test
    public void testTraverse() {
        final StubGrid grid = new StubGrid();
        String[] words = new String[WORDS.length];
        
        int count = 0;
        for (String word : WORDS) {
            traverse.setWord(word);
            traverse.traverse(grid);
            words[count++] = concatLetters(grid);
            grid.points.clear();
        }
        
        assertArrayEquals(WORDS, words);
    }
    
    private String concatLetters(StubGrid grid) {
        final StringBuilder builder = new StringBuilder();
        
        for (Point point : grid.points) {
            builder.append(grid.getLetterAt(point));
        }
        
        return builder.toString();
    }

}

class StubGrid implements Grid {
    
    public List<Point> points = new ArrayList<Point>();

    public String getLetterAt(Point point) {
        return GRID[point.y][point.x];
    }

    public void markLetterAt(Point point) {
        points.add(point);
    }

    public boolean isValidLetter(Point point) {
        int row = point.y;
        int col = point.x;

        if (row < 0 || row > GRID.length - 1) {
            return false;
        }

        if (col < 0 || col > GRID[row].length - 1) {
            return false;
        }

        return true;
    }

    public int getRows() {
        return GRID.length;
    }

    public int getCols() {
        return GRID[0].length;
    }
    
}
