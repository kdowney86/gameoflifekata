package main;

import java.util.ArrayList;

import main.strategy.GameOfLifeStrategy;

/**
 * Created by kelvin on 06/06/17.
 */
public class GameOfLife {

    private ArrayList<GameOfLifeStrategy> strategies;

    public GameOfLife(ArrayList <GameOfLifeStrategy> strategies) {
        this.strategies = strategies;
    }

    public ArrayList<ArrayList<String>> process(ArrayList<ArrayList<String>> list) {

        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        processCells(resultList, list);

        return resultList;
    }

    private void processCells(ArrayList<ArrayList<String>> tempList, ArrayList<ArrayList<String>> originalList) {
        for (int i = 0; i < originalList.size(); i++) {
            ArrayList<String> lineList = new ArrayList<>();
            for (int j = 0; j < originalList.get(i).size(); j++) {
                String processedCell = processStrategiesForCell(i, j, originalList);
                lineList.add(processedCell);
            }
            tempList.add(lineList);
        }
    }

    private String processStrategiesForCell(int iPos, int jPos, ArrayList<ArrayList<String>> originalList) {
        String processedCell = "";
        for (int x = 0; x < strategies.size(); x++)
            processedCell = strategies.get(x).getNextGenerationForCell(originalList, iPos, jPos, processedCell);
        return processedCell;
    }
}
