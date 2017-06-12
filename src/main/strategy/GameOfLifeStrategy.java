package main.strategy;

import java.util.ArrayList;

/**
 * Created by kelvin on 12/06/17.
 */
public interface GameOfLifeStrategy {

    String getNextGenerationForCell(ArrayList<ArrayList<String>> originalList, int iPos, int jPos, String processedCell);

}
