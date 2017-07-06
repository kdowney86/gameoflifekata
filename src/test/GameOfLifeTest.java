package test;

import main.GameOfLife;
import main.builder.GameBoardBuilder;
import main.constants.GameOfLifeConstants;
import main.model.Cell;
import main.model.GameBoard;
import main.strategy.impl.OvercrowdingStrategy;
import main.strategy.impl.ReproductionStrategy;
import main.strategy.impl.SurvivalStrategy;
import main.strategy.impl.UnderpopulationStrategy;
import main.strategy.manager.StrategyManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kelvin on 03/07/17.
 */
public class GameOfLifeTest {

        /*
        1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
        2. Any live cell with more than three live neighbours dies, as if by overcrowding.
        3. Any live cell with two or three live neighbours lives on to the next generation.
        4. Any dead cell with exactly three live neighbours becomes a live cell.
     */

    private GameOfLife gameOfLife;
    private GameBoardBuilder gameBoardBuilder;
    private final String ALIVE_STR = GameOfLifeConstants.ALIVE_STR;
    private final String DEAD_STR = GameOfLifeConstants.DEAD_STR;

    @Before
    public void setUp() {
        StrategyManager strategyManager = new StrategyManager();
        strategyManager.addStrategy(new UnderpopulationStrategy());
        strategyManager.addStrategy(new OvercrowdingStrategy());
        strategyManager.addStrategy(new SurvivalStrategy());
        strategyManager.addStrategy(new ReproductionStrategy());

        gameOfLife = new GameOfLife(strategyManager);
        gameBoardBuilder = new GameBoardBuilder();
    }

    //Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    @Test
    public void testAnyLiveCellWithFewerThanTwoLiveNeighboursDies() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        GameBoard board = gameBoardBuilder.build();

        int xPos = 2;
        int yPos = 1;

        //when
        GameBoard resultBoard = gameOfLife.process(board);

        //then
        ArrayList<ArrayList<Cell>> resultCells = resultBoard.getCells();
        Assert.assertEquals(false, resultCells.get(xPos).get(yPos).isAlive());
    }

    //Any live cell with more than three live neighbours dies, as if by overcrowding.
    @Test
    public void testAnyLiveCellWithMoreThanThreeLiveNeighboursDies() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        GameBoard board = gameBoardBuilder.build();
        int xPos = 2;
        int yPos = 1;

        //when
        GameBoard resultBoard = gameOfLife.process(board);

        //then
        ArrayList<ArrayList<Cell>> resultCells = resultBoard.getCells();
        Assert.assertEquals(false, resultCells.get(xPos).get(yPos).isAlive());
    }

    //Any live cell with two or three live neighbours lives on to the next generation.
    @Test
    public void testAnyLiveCellWithTwoLiveNeighboursLives() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        GameBoard board = gameBoardBuilder.build();
        int xPos = 2;
        int yPos = 1;

        //when
        GameBoard resultBoard = gameOfLife.process(board);

        //then
        ArrayList<ArrayList<Cell>> resultCells = resultBoard.getCells();
        Assert.assertEquals(true, resultCells.get(xPos).get(yPos).isAlive());
    }

    //Any live cell with two or three live neighbours lives on to the next generation.
    @Test
    public void testAnyLiveCellWithThreeLiveNeighboursLives() {
        //given
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        gameBoardBuilder = gameBoardBuilder.withRow(new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        GameBoard board = gameBoardBuilder.build();
        int xPos = 2;
        int yPos = 1;

        //when
        GameBoard resultBoard = gameOfLife.process(board);

        //then
        ArrayList<ArrayList<Cell>> resultCells = resultBoard.getCells();
        Assert.assertEquals(true, resultCells.get(xPos).get(yPos).isAlive());
    }
}
