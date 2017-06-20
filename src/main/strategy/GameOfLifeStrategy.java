package main.strategy;

import main.model.Cell;
import main.model.GameBoard;

/**
 * Created by kelvin on 12/06/17.
 */
public interface GameOfLifeStrategy {

    Cell getNextGenerationForCell(GameBoard gameBoard, int rowNumber, int colNumber, Cell cell);

}
