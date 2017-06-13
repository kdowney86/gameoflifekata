package main.strategy.impl;

import main.constants.GameOfLifeConstants;
import main.neighbourcounter.NeighbourCounter;
import main.strategy.GameOfLifeStrategy;

import java.util.ArrayList;

/**
 * Created by kelvin on 12/06/17.
 */
public class OvercrowdingStrategy implements GameOfLifeStrategy {

    @Override
    public String getNextGenerationForCell(ArrayList<ArrayList<String>> originalList, int iPos, int jPos, String processedCell) {
        final String currentCell = originalList.get(iPos).get(jPos);
        if (processedCell.equals("") && (currentCell.equals(GameOfLifeConstants.ALIVE_STR) && NeighbourCounter.count(originalList, iPos, jPos) < 2))
            processedCell = GameOfLifeConstants.DEAD_STR;

        return processedCell;
    }
}
