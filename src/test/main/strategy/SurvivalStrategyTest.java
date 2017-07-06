package main.strategy;

import main.builder.GameBoardBuilder;
import main.constants.GameOfLifeConstants;
import main.model.Cell;
import main.model.GameBoard;
import main.strategy.impl.SurvivalStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kelvin on 20/06/17.
 */
public class SurvivalStrategyTest {
    private final String DEAD_STR = GameOfLifeConstants.DEAD_STR;
    private final String ALIVE_STR = GameOfLifeConstants.ALIVE_STR;

    private SurvivalStrategy survivalStrategy = new SurvivalStrategy();
    private GameBoard gameBoard;
    private GameBoardBuilder gameBoardBuilder;

    @Before
    public void setUp() {
        gameBoardBuilder = new GameBoardBuilder();
    }

    @Test
    public void testLiveCellWithTwoNeighboursLivesOn() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 1;
        int colNumber = 1;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = survivalStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(true, cell.isAlive());
    }

    @Test
    public void testLiveCellWithThreeNeighboursLivesOn() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(ALIVE_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(ALIVE_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 0;
        int colNumber = 1;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = survivalStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(true, cell.isAlive());
    }

    @Test
    public void testLiveCellWithOneNeighbourUnprocessed() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(ALIVE_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 0;
        int colNumber = 0;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = survivalStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(true, cell.isAlive());
    }

    @Test
    public void testLiveCellWithFourNeighboursUnprocessed() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(ALIVE_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(ALIVE_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 2;
        int colNumber = 1;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = survivalStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(true, cell.isAlive());
    }

    @Test
    public void testDeadCellWithFourNeighboursUnprocessed() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(ALIVE_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(ALIVE_STR, DEAD_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 2;
        int colNumber = 1;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = survivalStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(false, cell.isAlive());
    }
}
