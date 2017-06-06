import java.util.ArrayList;

/**
 * Created by kelvin on 06/06/17.
 */
public class GameOfLife {

    public static ArrayList<ArrayList<String>> process(ArrayList<ArrayList<String>> list) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                list.get(i).set(j, ".");
            }
        }

        return list;
    }
}
