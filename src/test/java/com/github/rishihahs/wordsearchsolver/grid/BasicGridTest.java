package com.github.rishihahs.wordsearchsolver.grid;

import static com.github.rishihahs.wordsearchsolver.Puzzle.GRID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class BasicGridTest {
    
    private BasicGrid grid;

    @Before
    public void setUp() throws Exception {
        grid = new BasicGrid(GRID);
    }

    @Test
    public void testGetLetterAt() {
        String[][] testGrid = new String[GRID.length][];
        Point dummy = new Point(0, 0);
        
        for (int r = 0; r < GRID.length; r++) {
            String[] col = new String[GRID[r].length];
            
            for (int c = 0; c < GRID[r].length; c++) {
                dummy.y = r;
                dummy.x = c;
                col[c] = grid.getLetterAt(dummy);
            }
            
            testGrid[r] = col;
        }
        
        assertTrue(Arrays.deepEquals(GRID, testGrid));
    }

    @Test
    public void testMarkLetterAt() {
        Set<Point> points = new HashSet<Point>();
        for (int r = 0; r < GRID.length; r++) {
            for (int c = 0; c < GRID[r].length; c++) {
                points.add(new Point(c, r));
            }
        }
        
        final Random random = new Random();
        for (int r = 0; r < GRID.length; r++) {
            for (int c = 0; c < GRID[r].length; c++) {
                int times = random.nextInt(4) + 1;
                for (int i = 0; i < times; i++) {
                    grid.markLetterAt(new Point(c, r));
                }
            }
        }
        
        assertEquals(points, grid.getMarkedPoints());
    }

    @Test
    public void testIsValidLetter() {
        assertTrue(grid.isValidLetter(new Point(0, 0)));
        assertFalse(grid.isValidLetter(new Point(-1, 0)));
        assertFalse(grid.isValidLetter(new Point(GRID.length, 0)));
    }

    @Test
    public void testGetRows() {
        assertEquals(GRID.length, grid.getRows());
    }

    @Test
    public void testGetCols() {
        assertEquals(GRID[0].length, grid.getCols());
    }

}
