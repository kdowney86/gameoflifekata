package main;

import java.util.ArrayList;
import java.util.List;

import main.builder.GameBoardBuilder;
import main.model.Cell;
import main.model.GameBoard;
import main.strategy.GameOfLifeStrategy;
import main.strategy.manager.StrategyManager;

/**
 * Created by kelvin on 06/06/17.
 */
public class GameOfLife {

    private StrategyManager strategyManager;

    public GameOfLife(StrategyManager strategyManager) {
        this.strategyManager = strategyManager;
    }

    public GameBoard process(GameBoard board) {
        return generate(board);
    }

    private GameBoard generate(GameBoard gameBoard) {
        GameBoardBuilder gameBoardBuilder = new GameBoardBuilder();

        for (int rowNumber = 0; rowNumber < gameBoard.getHeight(); rowNumber++) {
            ArrayList<Cell> lineList = new ArrayList<>();
            for (int colNumber = 0; colNumber < gameBoard.getWidth(); colNumber++) {
                Cell processedCell = processStrategiesForCell(rowNumber, colNumber, gameBoard);
                lineList.add(processedCell);
            }
            gameBoardBuilder = gameBoardBuilder.withRowOfCells(lineList);
        }
        return gameBoardBuilder.build();
    }

    private Cell processStrategiesForCell(int rowNumber, int colNumber, GameBoard gameBoard) {
        Cell processedCell = new Cell();
        List<GameOfLifeStrategy> strategies = strategyManager.getStrategies();

        for (int x = 0; x < strategies.size(); x++)
            processedCell = strategies.get(x).getNextGenerationForCell(gameBoard, rowNumber, colNumber, processedCell);
        return processedCell;
    }
}
