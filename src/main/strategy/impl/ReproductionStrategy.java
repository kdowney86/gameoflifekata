package main.strategy.impl;

import main.constants.GameOfLifeConstants;
import main.neighbourcounter.NeighbourCounter;
import main.strategy.GameOfLifeStrategy;

import java.util.ArrayList;

/**
 * Created by kelvin on 13/06/17.
 */
public class ReproductionStrategy implements GameOfLifeStrategy {
    @Override
    public String getNextGenerationForCell(ArrayList<ArrayList<String>> originalList, int iPos, int jPos, String processedCell) {
        final String currentCell = originalList.get(iPos).get(jPos);
        processedCell = processCell(originalList, iPos, jPos, processedCell, currentCell);

        return processedCell;
    }

    private String processCell(ArrayList<ArrayList<String>> originalList, int iPos, int jPos, String processedCell, String currentCell) {
        if (processedCell.equals("") && (currentCell.equals(GameOfLifeConstants.DEAD_STR) && (NeighbourCounter.count(originalList, iPos, jPos) == 3)))
            processedCell = GameOfLifeConstants.ALIVE_STR;
        return processedCell;
    }
}
