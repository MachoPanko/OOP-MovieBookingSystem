package model.classes;

public class Seating {
    private boolean occupied;
    private int row;
    private int column;

    public Seating(int row, int column){
        this.occupied = false;
        this.row = row;
        this.column = column;
    }
    public void occupySeat(){
        this.occupied = true;
    }
    public boolean isOccupied(){
        return occupied;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
