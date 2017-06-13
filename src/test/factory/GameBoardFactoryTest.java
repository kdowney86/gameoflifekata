package test.factory;

import main.constants.GameOfLifeConstants;
import main.factory.GameBoardFactory;
import main.model.GameBoard;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Created by kelvin on 13/06/17.
 */
public class GameBoardFactoryTest {


    @Test
    public void test1x1BoardReturned() {
        //given
        ArrayList<String> singleElementRow = new ArrayList<>();
        singleElementRow.add("1");
        final int height = 1;
        final int width = 1;

        //when
        GameBoard resultBoard = new GameBoardFactory().withHeight(1).withWidth(1).withRow(singleElementRow).build();

        //then
        Assert.assertEquals(resultBoard.getHeight(), height);
        Assert.assertEquals(resultBoard.getWidth(), width);
        Assert.assertEquals(resultBoard.getCellValue(0, 0), GameOfLifeConstants.ALIVE_STR);
    }
}
