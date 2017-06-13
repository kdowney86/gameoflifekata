package test.builder;

import main.constants.GameOfLifeConstants;
import main.builder.GameBoardBuilder;
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
        ArrayList<Integer> singleElementRow = new ArrayList<>();
        singleElementRow.add(1);
        final int height = 1;
        final int width = 1;

        //when
        GameBoard resultBoard = new GameBoardBuilder().withRow(singleElementRow).build();

        //then
        Assert.assertEquals(resultBoard.getHeight(), height);
        Assert.assertEquals(resultBoard.getWidth(), width);
        Assert.assertEquals(resultBoard.getCellValue(0, 0), GameOfLifeConstants.ALIVE_STR);
    }

    @Test
    public void test2x5BoardReturned() {
        //given
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(0);


        final int height = 5;
        final int width = 2;

        //when
        GameBoard resultBoard = new GameBoardBuilder().withRow(row).withRow(row).withRow(row).withRow(row).withRow(row).build();

        //then
        Assert.assertEquals(resultBoard.getHeight(), height);
        Assert.assertEquals(resultBoard.getWidth(), width);
        Assert.assertEquals(resultBoard.getCellValue(0, 0), GameOfLifeConstants.ALIVE_STR);
        Assert.assertEquals(resultBoard.getCellValue(0, 1), GameOfLifeConstants.DEAD_STR);
        Assert.assertEquals(resultBoard.getCellValue(1, 0), GameOfLifeConstants.ALIVE_STR);
        Assert.assertEquals(resultBoard.getCellValue(1, 1), GameOfLifeConstants.DEAD_STR);
        Assert.assertEquals(resultBoard.getCellValue(2, 0), GameOfLifeConstants.ALIVE_STR);
        Assert.assertEquals(resultBoard.getCellValue(2, 1), GameOfLifeConstants.DEAD_STR);
        Assert.assertEquals(resultBoard.getCellValue(3, 0), GameOfLifeConstants.ALIVE_STR);
        Assert.assertEquals(resultBoard.getCellValue(3, 1), GameOfLifeConstants.DEAD_STR);
        Assert.assertEquals(resultBoard.getCellValue(4, 0), GameOfLifeConstants.ALIVE_STR);
        Assert.assertEquals(resultBoard.getCellValue(4, 1), GameOfLifeConstants.DEAD_STR);
    }
}
