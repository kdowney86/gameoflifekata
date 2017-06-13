package main.model;

/**
 * Created by kelvin on 12/06/17.
 */
public class Cell {

    private boolean processed;
    private int rowNumber;
    private int colNumber;
    private String value;

    public Cell(int rowNumber, int colNumber, String value) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.value = value;
        this.processed = false;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColNumber() {
        return colNumber;
    }

    public void setColNumber(int colNumber) {
        this.colNumber = colNumber;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
