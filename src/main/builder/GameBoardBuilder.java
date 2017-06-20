package main.builder;

import main.constants.GameOfLifeConstants;
import main.model.Cell;
import main.model.GameBoard;

import java.util.ArrayList;

/**
 * Created by kelvin on 13/06/17.
 */
public class GameBoardBuilder {

    private ArrayList<ArrayList<Cell>> cells = new ArrayList<>();

    public GameBoardBuilder withRow(ArrayList<String> rowValues) {
        ArrayList<Cell> row = new ArrayList<>();
        processCellValues(rowValues, row);

        return this;
    }

    public GameBoardBuilder withRowOfCells(ArrayList<Cell> rowCells) {
        cells.add(rowCells);

        return this;
    }

    private void processCellValues(ArrayList<String> rowValues, ArrayList<Cell> row) {
        for (String cellValue: rowValues) {
            row.add(new Cell(isAlive(cellValue)));
        }
        cells.add(row);
    }

    private boolean isAlive(String cellValue) {
        return cellValue.equals(GameOfLifeConstants.ALIVE_STR);
    }

    public GameBoard build() {
        GameBoard resultBoard = new GameBoard();
        resultBoard.setCells(cells);
        return resultBoard;
    }
}
