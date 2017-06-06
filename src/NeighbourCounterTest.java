import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kelvin on 06/06/17.
 */
public class NeighbourCounterTest {

    private ArrayList<ArrayList<String>> test2dArrayList;
    private final String ALIVE_STR = "*";
    private final String DEAD_STR = ".";

    @Test
    public void countNoNeighboursTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));

        int expected = 0;

        //when
        int result = NeighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countOneNeighbourToTheNorthTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));

        int expected = 1;

        //when
        int result = NeighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countOneNeighbourToTheEastTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, ALIVE_STR, DEAD_STR)));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));

        int expected = 1;

        //when
        int result = NeighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countOneNeighbourToTheSouthTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));

        int expected = 1;

        //when
        int result = NeighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countOneNeighbourToTheWestTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(ALIVE_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));

        int expected = 1;

        //when
        int result = NeighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countTwoNeighboursNorthAndWestTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(DEAD_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(ALIVE_STR, ALIVE_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(DEAD_STR, DEAD_STR, DEAD_STR, DEAD_STR)));

        int expected = 2;

        //when
        int result = NeighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

}
