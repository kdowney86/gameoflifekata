package main.neighbourcounter;

import main.model.Cell;

import java.util.ArrayList;

/**
 * Created by kelvin on 06/06/17.
 */
public class NeighbourCounter {

    private final int MIN_TEST_RANGE = -1;
    private final int MAX_TEST_RANGE = 1;

    public int count(ArrayList<ArrayList<Cell>> list, int rowNumber, int colNumber) {
        return processNeighbouringCells(list, rowNumber, colNumber);
    }

    private int processNeighbouringCells(ArrayList<ArrayList<Cell>> list, int rowNumber, int colNumber) {
        int result = 0;

        for (int rowToTest = MIN_TEST_RANGE; rowToTest <= MAX_TEST_RANGE; rowToTest++) {
            for (int columnToTest = MIN_TEST_RANGE; columnToTest <= MAX_TEST_RANGE; columnToTest++) {
                if (isValidNeighbour(list, rowNumber, colNumber, rowToTest, columnToTest)) {
                    result += getNeighbourCount(list, rowNumber, colNumber, rowToTest, columnToTest);
                }
            }
        }
        
        return result;
    }

    private boolean isValidNeighbour(ArrayList<ArrayList<Cell>> list, int rowNumber, int colNumber, int i, int j) {
        boolean isDifferentCell= !(i == 0 && j == 0);
        return  (isDifferentCell) && checkIsInBounds(list, rowNumber, colNumber, i, j);
    }

    private int getNeighbourCount(ArrayList<ArrayList<Cell>> list, int xPos, int yPos, int xDiff, int yDiff) {
        int neighbour = 0;

        if (list.get(xPos + xDiff).get(yPos + yDiff).isAlive()) neighbour++;

        return neighbour;
    }

    private boolean checkIsInBounds(ArrayList<ArrayList<Cell>> list, int rowNumber, int colNumber, int rowDiff, int colDiff) {
        boolean result = true;

        if (rowNumber + rowDiff < 0) result = false;
        if (colNumber + colDiff < 0) result = false;
        if (rowNumber + rowDiff > list.size() - 1) result = false;
        if (colNumber + colDiff > list.get(0).size() -1) result = false;

        return result;
    }
}
