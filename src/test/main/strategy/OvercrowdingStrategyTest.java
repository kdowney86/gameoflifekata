package main.strategy;

import main.builder.GameBoardBuilder;
import main.constants.GameOfLifeConstants;
import main.model.Cell;
import main.model.GameBoard;
import main.strategy.impl.OvercrowdingStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kelvin on 20/06/17.
 */
public class OvercrowdingStrategyTest {

    private final String DEAD_STR = GameOfLifeConstants.DEAD_STR;
    private final String ALIVE_STR = GameOfLifeConstants.ALIVE_STR;

    private OvercrowdingStrategy overcrowdingStrategy = new OvercrowdingStrategy();
    private GameBoard gameBoard;
    private GameBoardBuilder gameBoardBuilder;

    @Before
    public void setUp() {
        gameBoardBuilder = new GameBoardBuilder();
    }

    @Test
    public void testCellWithThreeLiveNeighboursUnprocessed() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 2;
        int colNumber = 1;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = overcrowdingStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(true, cell.isAlive());
    }

    @Test
    public void testLiveCellWithFourLiveNeighboursDies() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 2;
        int colNumber = 1;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = overcrowdingStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(false, cell.isAlive());
    }

    @Test
    public void testLiveCellWithFiveLiveNeighboursDies() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(ALIVE_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoard = gameBoardBuilder.build();

        int rowNumber = 1;
        int colNumber = 1;
        Cell cell = gameBoard.getCell(rowNumber, colNumber);

        //when
        cell = overcrowdingStrategy.getNextGenerationForCell(gameBoard, rowNumber, colNumber, cell);

        //then
        Assert.assertEquals(false, cell.isAlive());
    }


}
