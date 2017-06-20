package main.model;

import main.GameOfLife;
import main.constants.GameOfLifeConstants;

import java.util.ArrayList;

/**
 * Created by kelvin on 12/06/17.
 */
public class GameBoard {

    private ArrayList<ArrayList<Cell>> cells;

    public int getHeight() {
        return cells.size();
    }

    public int getWidth() {
        return cells.get(0).size();
    }

    public ArrayList<ArrayList<Cell>> getCells() {
        return cells;
    }

    public void setCells(ArrayList<ArrayList<Cell>> cells) {
        this.cells = cells;
    }

    public Cell getCell(int rowNumber, int colNumber) {
        return cells.get(rowNumber).get(colNumber);
    }

    public void print() {
        String value;
        for (ArrayList<Cell> row: cells) {
            for (Cell cell: row) {
                if (cell.isAlive()) value = GameOfLifeConstants.ALIVE_STR;
                else value = GameOfLifeConstants.DEAD_STR;
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
