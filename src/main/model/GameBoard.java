package main.model;

import java.util.ArrayList;

/**
 * Created by kelvin on 12/06/17.
 */
public class GameBoard {

    private int height;
    private int width;
    private ArrayList<ArrayList<Cell>> cells;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ArrayList<ArrayList<Cell>> getCells() {
        return cells;
    }

    public void setCells(ArrayList<ArrayList<Cell>> cells) {
        this.cells = cells;
    }

    public String getCellValue(int rowNumber, int colNumber) {
        return cells.get(rowNumber).get(colNumber).getValue();
    }
}
