package model.classes;

public class Seating {
    private boolean occupied;
    private boolean toDisplay;
    private boolean isCoupleSeat; //i++ twice

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isToDisplay() {
        return toDisplay;
    }

    public void setToDisplay(boolean toDisplay) {
        this.toDisplay = toDisplay;
    }

    public boolean isCoupleSeat() {
        return isCoupleSeat;
    }

    public void setCoupleSeat(boolean coupleSeat) {
        isCoupleSeat = coupleSeat;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    private int row;
    private int column;

    public Seating(int row, int column){
        this.occupied = false;
        this.row = row;
        this.column = column;
        this.toDisplay = true;
        this.isCoupleSeat = false;
    }

    public void occupySeat(){
        this.occupied = true;
    }
    public void unOccupySeat(){this.occupied = false;}
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
