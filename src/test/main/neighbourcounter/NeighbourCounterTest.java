package test.main.neighbourcounter;

import main.model.Cell;
import main.neighbourcounter.NeighbourCounter;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kelvin on 06/06/17.
 */
public class NeighbourCounterTest {

    private ArrayList<ArrayList<Cell>> test2dArrayList;
    private NeighbourCounter neighbourCounter = new NeighbourCounter();

    @Test
    public void countNoNeighboursTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));

        int expected = 0;

        //when
        int result = neighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countOneNeighbourToTheNorthTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));

        int expected = 1;

        //when
        int result = neighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countOneNeighbourToTheEastTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(true), new Cell(true), new Cell(false))));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));

        int expected = 1;

        //when
        int result = neighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countOneNeighbourToTheSouthTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));

        int expected = 1;

        //when
        int result = neighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countOneNeighbourToTheWestTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(new Cell(true), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));

        int expected = 1;

        //when
        int result = neighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countTwoNeighboursNorthAndWestTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(new Cell(true), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));

        int expected = 2;

        //when
        int result = neighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countThreeNeighboursNorthWestAndSouthTest() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(new Cell(true), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));

        int expected = 3;

        //when
        int result = neighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void countFourNeighbours() {
        //given
        test2dArrayList = new ArrayList<>();
        test2dArrayList.add(0, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));
        test2dArrayList.add(1, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(2, new ArrayList<>(Arrays.asList(new Cell(true), new Cell(true), new Cell(true), new Cell(false))));
        test2dArrayList.add(3, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false))));
        test2dArrayList.add(4, new ArrayList<>(Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false))));

        int expected = 4;

        //when
        int result = neighbourCounter.count(test2dArrayList, 2, 1);

        //then
        Assert.assertEquals(expected, result);
    }

}
