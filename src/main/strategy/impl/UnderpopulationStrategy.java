package main.strategy.impl;

import main.model.Cell;
import main.model.GameBoard;
import main.neighbourcounter.NeighbourCounter;
import main.strategy.GameOfLifeStrategy;

/**
 * Created by kelvin on 12/06/17.
 */
public class UnderpopulationStrategy implements GameOfLifeStrategy {

    @Override
    public Cell getNextGenerationForCell(GameBoard gameBoard, int rowNumber, int colNumber, Cell cell) {

        if (!cell.isProcessed()) {
            Cell currentCell = gameBoard.getCell(rowNumber, colNumber);
            final int neighbourCount = NeighbourCounter.count(gameBoard.getCells(), rowNumber, colNumber);
            if (currentCell.isAlive() && neighbourCount < 2) {
                cell.setAlive(false);
            }
        }

        return cell;
    }
}
