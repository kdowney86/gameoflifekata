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
    private int rowNumber = 0;

    public GameBoardBuilder withRow(ArrayList<Integer> rowValues) {
        ArrayList<Cell> row = new ArrayList<>();

        int colNumber = 0;
        processCellValues(rowValues, row, colNumber);

        return this;
    }

    private void processCellValues(ArrayList<Integer> rowValues, ArrayList<Cell> row, int colNumber) {
        for (Integer cellValue: rowValues) {
            if (cellValue == 1) {
                row.add(new Cell(rowNumber, colNumber, GameOfLifeConstants.ALIVE_STR));

            } else {
                row.add(new Cell(rowNumber, colNumber, GameOfLifeConstants.DEAD_STR));
            }
            colNumber++;
        }
        rowNumber++;

        cells.add(row);
    }

    public GameBoard build() {
        GameBoard resultBoard = new GameBoard();
        resultBoard.setCells(cells);
        return resultBoard;
    }
}
