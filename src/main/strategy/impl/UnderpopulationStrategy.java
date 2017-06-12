package main.strategy.impl;

import main.constants.GameOfLifeConstants;
import main.neighbourcounter.NeighbourCounter;
import main.strategy.GameOfLifeStrategy;

import java.util.ArrayList;

/**
 * Created by kelvin on 12/06/17.
 */
public class UnderpopulationStrategy implements GameOfLifeStrategy {

    @Override
    public String getNextGenerationForCell(ArrayList<ArrayList<String>> originalList, int iPos, int jPos, String processedCell) {

        final String currentCellValue = originalList.get(iPos).get(jPos);
        if (currentCellValue.equals(GameOfLifeConstants.ALIVE_STR) && NeighbourCounter.count(originalList, iPos, jPos) > 3)
            processedCell = GameOfLifeConstants.DEAD_STR;

        return processedCell;
    }
}
