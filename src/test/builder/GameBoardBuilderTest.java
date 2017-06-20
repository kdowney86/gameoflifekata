package test.builder;

import main.builder.GameBoardBuilder;
import main.model.Cell;
import main.model.GameBoard;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Created by kelvin on 13/06/17.
 */
public class GameBoardBuilderTest {


    @Test
    public void test1x1BoardReturned() {
        //given
        ArrayList<String> singleElementRow = new ArrayList<>();
        singleElementRow.add("*");
        final int height = 1;
        final int width = 1;

        //when
        GameBoard resultBoard = new GameBoardBuilder().withRow(singleElementRow).build();

        //then
        Assert.assertEquals(resultBoard.getHeight(), height);
        Assert.assertEquals(resultBoard.getWidth(), width);
        Assert.assertEquals(resultBoard.getCell(0, 0).isAlive(), true);
    }

    @Test
    public void test2x5BoardReturned() {
        //given
        ArrayList<Cell> row = new ArrayList<>();
        row.add(new Cell(true));
        row.add(new Cell(false));


        final int height = 5;
        final int width = 2;

        //when
        GameBoard resultBoard = new GameBoardBuilder().withRowOfCells(row).withRowOfCells(row).withRowOfCells(row).withRowOfCells(row).withRowOfCells(row).build();

        //then
        Assert.assertEquals(resultBoard.getHeight(), height);
        Assert.assertEquals(resultBoard.getWidth(), width);
        Assert.assertEquals(resultBoard.getCell(0, 0).isAlive(), true);
        Assert.assertEquals(resultBoard.getCell(0, 1).isAlive(), false);
        Assert.assertEquals(resultBoard.getCell(1, 0).isAlive(), true);
        Assert.assertEquals(resultBoard.getCell(1, 1).isAlive(), false);
        Assert.assertEquals(resultBoard.getCell(2, 0).isAlive(), true);
        Assert.assertEquals(resultBoard.getCell(2, 1).isAlive(), false);
        Assert.assertEquals(resultBoard.getCell(3, 0).isAlive(), true);
        Assert.assertEquals(resultBoard.getCell(3, 1).isAlive(), false);
        Assert.assertEquals(resultBoard.getCell(4, 0).isAlive(), true);
        Assert.assertEquals(resultBoard.getCell(4, 1).isAlive(), false);
    }
}
