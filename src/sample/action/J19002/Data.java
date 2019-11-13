package sample.action.J19002;

public class Data {

    private int row;
    private int col;
    private int data;

    public Data(int row, int col, int data) {
        this.col = col;
        this.row = row;
        this.data = data;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

    public double getValue() {
        return data;
    }
}
