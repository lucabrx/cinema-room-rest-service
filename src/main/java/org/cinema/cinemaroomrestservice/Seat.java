package org.cinema.cinemaroomrestservice;

public class Seat {
    public int row,column;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Seat() {

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

