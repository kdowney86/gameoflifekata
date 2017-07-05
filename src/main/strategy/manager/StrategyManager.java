package main.strategy.manager;

import main.model.Cell;
import main.model.GameBoard;
import main.strategy.GameOfLifeStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kelvin on 03/07/17.
 */
public class StrategyManager {

    private List<GameOfLifeStrategy> strategies;

    public StrategyManager() {
        this.strategies = new ArrayList<>();
    }

    public void addStrategy(GameOfLifeStrategy strategy) {
        strategies.add(strategy);
    }

    public Cell processStrategiesForCell(int rowNumber, int colNumber, GameBoard gameBoard) {
        Cell processedCell = gameBoard.getCell(rowNumber, colNumber);

        for (int x = 0; x < strategies.size(); x++)
            processedCell = strategies.get(x).getNextGenerationForCell(gameBoard, rowNumber, colNumber, processedCell);
        return processedCell;
    }
}
