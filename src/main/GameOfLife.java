package main;

import java.util.ArrayList;

import main.constants.GameOfLifeConstants;
import main.neighbourcounter.NeighbourCounter;

/**
 * Created by kelvin on 06/06/17.
 */
public class GameOfLife {

    public static ArrayList<ArrayList<String>> process(ArrayList<ArrayList<String>> list) {

        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        processCells(resultList, list);

        return resultList;
    }

    private static void processCells(ArrayList<ArrayList<String>> tempList, ArrayList<ArrayList<String>> originalList) {
        for (int i = 0; i < originalList.size(); i++) {
            ArrayList<String> lineList = new ArrayList<>();
            for (int j = 0; j < originalList.get(i).size(); j++) {
                if (originalList.get(i).get(j).equals(GameOfLifeConstants.ALIVE_STR) && NeighbourCounter.count(originalList, i, j) < 2)
                    lineList.add(GameOfLifeConstants.DEAD_STR);
                else if (originalList.get(i).get(j).equals(GameOfLifeConstants.ALIVE_STR) && NeighbourCounter.count(originalList, i, j) > 3)
                    lineList.add(GameOfLifeConstants.DEAD_STR);
                else if (originalList.get(i).get(j).equals(GameOfLifeConstants.ALIVE_STR) && NeighbourCounter.count(originalList, i, j) == 2
                        || originalList.get(i).get(j).equals(GameOfLifeConstants.ALIVE_STR) && NeighbourCounter.count(originalList, i, j) == 3)
                    lineList.add(GameOfLifeConstants.ALIVE_STR);
                else lineList.add(GameOfLifeConstants.DEAD_STR);
            }
            tempList.add(lineList);
        }
    }
}
