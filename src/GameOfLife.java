import java.util.ArrayList;

/**
 * Created by kelvin on 06/06/17.
 */
public class GameOfLife {

    public static ArrayList<ArrayList<String>> process(ArrayList<ArrayList<String>> list) {

        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        fillEmptyCells(resultList, list);
        processCellsWithFewerThanTwoNeighbours(resultList, list);


        return resultList;
    }

    private static void processCellsWithFewerThanTwoNeighbours(ArrayList<ArrayList<String>> tempList, ArrayList<ArrayList<String>> originalList) {
        for (int i = 0; i < tempList.size(); i++) {
            for (int j = 0; j < tempList.get(i).size(); j++) {
                if (NeighbourCounter.count(originalList, i, j) < 2)
                    tempList.get(i).set(j, GameOfLifeConstants.DEAD_STR);
            }
        }
    }

    private static void fillEmptyCells(ArrayList<ArrayList<String>> listToBeFilled, ArrayList<ArrayList<String>> originalList) {
        ArrayList<String> listLine = new ArrayList<>();
        for (int i = 0; i < originalList.get(0).size(); i++) {
            listLine.add(GameOfLifeConstants.DEAD_STR);
        }
        for (int j = 0; j < originalList.size(); j++) {
            listToBeFilled.add(listLine);
        }
    }
}
