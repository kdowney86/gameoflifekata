package main.neighbourcounter;

import main.model.Cell;

import java.util.ArrayList;

/**
 * Created by kelvin on 06/06/17.
 */
public class NeighbourCounter {

    public static int count(ArrayList<ArrayList<Cell>> list, int rowNumber, int colNumber) {

        int result = 0;
        result += getNeighboursToTheWest(list, rowNumber, colNumber);
        result += getNeighboursToTheNorth(list, rowNumber, colNumber);
        result += getNeighboursToTheEast(list, rowNumber, colNumber);
        result += getNeighboursToTheSouth(list, rowNumber, colNumber);
        result += getNeighboursToTheNorthWest(list, rowNumber, colNumber);
        result += getNeighboursToTheNorthEast(list, rowNumber, colNumber);
        result += getNeighboursToTheSouthWest(list, rowNumber, colNumber);
        result += getNeighboursToTheSouthEast(list, rowNumber, colNumber);


        return result;
    }

    private static int getNeighboursToTheWest(ArrayList<ArrayList<Cell>> list, int rowNumber, int colNumber) {
        int result = 0;
        int xDiff = -1;
        int yDiff = 0;

        if (checkIsInBounds(list, rowNumber, colNumber, xDiff, yDiff)){
            result += getNeighbour(list, rowNumber, colNumber, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighboursToTheNorthWest(ArrayList<ArrayList<Cell>> list, int xPos, int yPos) {
        int result = 0;
        int xDiff = -1;
        int yDiff = -1;

        if (checkIsInBounds(list, xPos, yPos, xDiff, yDiff)){
            result += getNeighbour(list, xPos, yPos, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighboursToTheNorth(ArrayList<ArrayList<Cell>> list, int xPos, int yPos) {
        int result = 0;
        int xDiff = 0;
        int yDiff = -1;

        if (checkIsInBounds(list, xPos, yPos, xDiff, yDiff)){
            result += getNeighbour(list, xPos, yPos, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighboursToTheNorthEast(ArrayList<ArrayList<Cell>> list, int xPos, int yPos) {
        int result = 0;
        int xDiff = 1;
        int yDiff = -1;

        if (checkIsInBounds(list, xPos, yPos, xDiff, yDiff)){
            result += getNeighbour(list, xPos, yPos, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighboursToTheEast(ArrayList<ArrayList<Cell>> list, int xPos, int yPos) {
        int result = 0;
        int xDiff = 1;
        int yDiff = 0;

        if (checkIsInBounds(list, xPos, yPos, xDiff, yDiff)){
            result += getNeighbour(list, xPos, yPos, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighboursToTheSouthWest(ArrayList<ArrayList<Cell>> list, int xPos, int yPos) {
        int result = 0;
        int xDiff = -1;
        int yDiff = 1;

        if (checkIsInBounds(list, xPos, yPos, xDiff, yDiff)){
            result += getNeighbour(list, xPos, yPos, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighboursToTheSouth(ArrayList<ArrayList<Cell>> list, int xPos, int yPos) {
        int result = 0;
        int xDiff = 0;
        int yDiff = 1;

        if (checkIsInBounds(list, xPos, yPos, xDiff, yDiff)){
            result += getNeighbour(list, xPos, yPos, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighboursToTheSouthEast(ArrayList<ArrayList<Cell>> list, int xPos, int yPos) {
        int result = 0;
        int xDiff = 1;
        int yDiff = 1;

        if (checkIsInBounds(list, xPos, yPos, xDiff, yDiff)){
            result += getNeighbour(list, xPos, yPos, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighbour(ArrayList<ArrayList<Cell>> list, int xPos, int yPos, int xDiff, int yDiff) {
        int neighbour = 0;

        if (list.get(xPos + xDiff).get(yPos + yDiff).isAlive()) neighbour++;

        return neighbour;
    }

    private static boolean checkIsInBounds(ArrayList<ArrayList<Cell>> list, int rowNumber, int colNumber, int rowDiff, int colDiff) {
        boolean result = true;

        if (rowNumber + rowDiff < 0) result = false;
        if (colNumber + colDiff < 0) result = false;
        if (rowNumber + rowDiff > list.size() - 1) result = false;
        if (colNumber + colDiff > list.get(0).size() -1) result = false;

        return result;
    }
}
