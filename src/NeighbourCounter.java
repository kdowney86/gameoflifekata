import java.util.ArrayList;

/**
 * Created by kelvin on 06/06/17.
 */
public class NeighbourCounter {

    public static int count(ArrayList<ArrayList<String>> list, int xPos, int yPos) {

        int result = 0;
        result += getNeighboursToTheWest(list, xPos, yPos);
        result += getNeighboursToTheNorth(list, xPos, yPos);
        result += getNeighboursToTheEast(list, xPos, yPos);
        result += getNeighboursToTheSouth(list, xPos, yPos);

        return result;
    }

    private static int getNeighboursToTheWest(ArrayList<ArrayList<String>> list, int xPos, int yPos) {
        int result = 0;
        int xDiff = -1;
        int yDiff = 0;

        if (checkIsInBounds(list, xPos, yPos, xDiff, yDiff)){
            result += getNeighbour(list, xPos, yPos, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighboursToTheNorth(ArrayList<ArrayList<String>> list, int xPos, int yPos) {
        int result = 0;
        int xDiff = 0;
        int yDiff = -1;

        if (checkIsInBounds(list, xPos, yPos, xDiff, yDiff)){
            result += getNeighbour(list, xPos, yPos, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighboursToTheEast(ArrayList<ArrayList<String>> list, int xPos, int yPos) {
        int result = 0;
        int xDiff = 1;
        int yDiff = 0;

        if (checkIsInBounds(list, xPos, yPos, xDiff, yDiff)){
            result += getNeighbour(list, xPos, yPos, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighboursToTheSouth(ArrayList<ArrayList<String>> list, int xPos, int yPos) {
        int result = 0;
        int xDiff = 0;
        int yDiff = 1;

        if (checkIsInBounds(list, xPos, yPos, xDiff, yDiff)){
            result += getNeighbour(list, xPos, yPos, xDiff, yDiff);
        }
        return result;
    }

    private static int getNeighbour(ArrayList<ArrayList<String>> list, int xPos, int yPos, int xDiff, int yDiff) {
        int neighbour = 0;

        if (list.get(xPos + xDiff).get(yPos + yDiff) == GameOfLifeConstants.ALIVE_STR) neighbour++;

        return neighbour;
    }

    private static boolean checkIsInBounds(ArrayList<ArrayList<String>> list, int xPos, int yPos, int xDiff, int yDiff) {
        boolean result = true;

        if (xPos + xDiff < 0) result = false;
        if (yPos + yDiff < 0) result = false;
        if (xPos + xDiff > list.size() - 1) result = false;
        if (yPos + yDiff > list.get(0).size() -1) result = false;

        return result;
    }
}
