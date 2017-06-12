import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kelvin on 06/06/17.
 */
public class GameOfLifeTests {

    /*
        1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
        2. Any live cell with more than three live neighbours dies, as if by overcrowding.
        3. Any live cell with two or three live neighbours lives on to the next generation.
        4. Any dead cell with exactly three live neighbours becomes a live cell.
     */

    private ArrayList<ArrayList<String>> test2dArrayList;
    private final String ALIVE_STR = GameOfLifeConstants.ALIVE_STR;
    private final String DEAD_STR = GameOfLifeConstants.DEAD_STR;

    //Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    @Test
    public void testAnyLiveCellWithFewerThanTwoLiveNeighboursDies() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));

        int xPos = 2;
        int yPos = 1;

        //when
        ArrayList<ArrayList<String>> result = GameOfLife.process(test2dArrayList);

        //then
        Assert.assertEquals(DEAD_STR, result.get(xPos).get(yPos));
    }

    //Any live cell with more than three live neighbours dies, as if by overcrowding.
    @Test
    public void testAnyLiveCellWithMoreThanThreeLiveNeighboursDies() {
        //given
        test2dArrayList = new ArrayList<>();
        int xPos = 2;
        int yPos = 1;
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));


        //when
        ArrayList<ArrayList<String>> result = GameOfLife.process(test2dArrayList);

        //then
        Assert.assertEquals(DEAD_STR, result.get(xPos).get(yPos));
    }

    //Any live cell with two or three live neighbours lives on to the next generation.
    @Test
    public void testAnyLiveCellWithTwoLiveNeighboursLives() {
        //given
        test2dArrayList = new ArrayList<>();
        int xPos = 2;
        int yPos = 1;
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));


        //when
        ArrayList<ArrayList<String>> result = GameOfLife.process(test2dArrayList);

        //then
        Assert.assertEquals(ALIVE_STR, result.get(xPos).get(yPos));
    }
}
