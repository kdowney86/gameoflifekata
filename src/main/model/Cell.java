package main.model;

/**
 * Created by kelvin on 12/06/17.
 */
public class Cell {

    private boolean alive;
    private boolean processed;

    public Cell(boolean alive) {
        this.alive = alive;
        this.processed = false;
    }

    public Cell() {
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

}
