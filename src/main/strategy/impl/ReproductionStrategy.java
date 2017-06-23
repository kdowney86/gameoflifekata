package main.strategy.impl;

import main.model.Cell;
import main.model.GameBoard;
import main.neighbourcounter.NeighbourCounter;
import main.strategy.GameOfLifeStrategy;


/**
 * Created by kelvin on 13/06/17.
 */
public class ReproductionStrategy implements GameOfLifeStrategy {

    private NeighbourCounter neighbourCounter;

    public ReproductionStrategy() {
        neighbourCounter = new NeighbourCounter();
    }

    @Override
    public Cell getNextGenerationForCell(GameBoard gameBoard, int rowNumber, int colNumber, Cell cell) {

        Cell currentCell = gameBoard.getCell(rowNumber, colNumber);
        final int neighbourCount = neighbourCounter.count(gameBoard.getCells(), rowNumber, colNumber);
        if (!currentCell.isAlive() && neighbourCount == 3) {
            cell.setAlive(true);
        }


        return cell;
    }
}
