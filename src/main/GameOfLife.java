package main;

import java.util.ArrayList;

import main.builder.GameBoardBuilder;
import main.model.Cell;
import main.model.GameBoard;
import main.strategy.GameOfLifeStrategy;

/**
 * Created by kelvin on 06/06/17.
 */
public class GameOfLife {

    private ArrayList<GameOfLifeStrategy> strategies;

    public GameOfLife(ArrayList <GameOfLifeStrategy> strategies) {
        this.strategies = strategies;
    }

    public GameBoard process(ArrayList<ArrayList<String>> list) {

        GameBoard processedBoard = getGameBoard(list);
        GameBoard nextGenBoard = generate(processedBoard);

        return nextGenBoard;
    }

    private GameBoard getGameBoard(ArrayList<ArrayList<String>> list) {
        GameBoardBuilder gameBoardBuilder = new GameBoardBuilder();

        for (ArrayList<String> row: list) {
            gameBoardBuilder = gameBoardBuilder.withRow(row);
        }

        return gameBoardBuilder.build();
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
        processedCell.setProcessed(false);

        for (int x = 0; x < strategies.size(); x++)
            processedCell = strategies.get(x).getNextGenerationForCell(gameBoard, rowNumber, colNumber, processedCell);
        return processedCell;
    }
}
