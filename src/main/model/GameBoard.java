package main.model;


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

}
