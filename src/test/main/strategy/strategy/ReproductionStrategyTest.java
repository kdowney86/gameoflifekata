package test.main.strategy.strategy;

import main.builder.GameBoardBuilder;
import main.constants.GameOfLifeConstants;
import main.model.Cell;
import main.model.GameBoard;
import main.strategy.impl.ReproductionStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kelvin on 20/06/17.
 */
public class ReproductionStrategyTest {
    private final String DEAD_STR = GameOfLifeConstants.DEAD_STR;
    private final String ALIVE_STR = GameOfLifeConstants.ALIVE_STR;

    private ReproductionStrategy reproductionStrategy = new ReproductionStrategy();
    private GameBoard gameBoard;
    private GameBoardBuilder gameBoardBuilder;

    @Before
    public void setUp() {
        gameBoardBuilder = new GameBoardBuilder();
    }

    @Test
    public void testDeadCellWithThreeLiveNeighboursLives() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 2;
        int colNumber = 2;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = reproductionStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(true, cell.isAlive());
    }

    @Test
    public void testDeadCellWithFourLiveNeighboursUnaffected() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, ALIVE_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 2;
        int colNumber = 2;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = reproductionStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(false, cell.isAlive());
    }

    @Test
    public void testDeadCellWithTwoLiveNeighboursUnaffected() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, ALIVE_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(ALIVE_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 4;
        int colNumber = 0;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = reproductionStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(false, cell.isAlive());
    }

    @Test
    public void testLiveCellWithThreeLiveNeighboursUnaffected() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, ALIVE_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(ALIVE_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 4;
        int colNumber = 2;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = reproductionStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(true, cell.isAlive());
    }
}
