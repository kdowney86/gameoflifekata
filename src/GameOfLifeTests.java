import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
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

    private GameOfLife gol;
    private ArrayList<ArrayList<String>> test2dArrayList;
    private final String ALIVE_STR = "*";
    private final String DEAD_STR = ".";

    @Test
    public void testAnyLiveCellWithFewerThanTwoLiveNeighboursDies() {
        gol = new GameOfLife();
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));

        ArrayList<ArrayList<String>> expectedArrayList = new ArrayList<>();
        expectedArrayList.add(0, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        expectedArrayList.add(1, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        expectedArrayList.add(2, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        expectedArrayList.add(3, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        expectedArrayList.add(4, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));

        ArrayList<ArrayList<String>> result = GameOfLife.process(test2dArrayList);
        Assert.assertEquals(expectedArrayList, result);
    }
}
