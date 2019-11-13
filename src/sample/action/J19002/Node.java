package sample.action.J19002;

/**
 * 0.数据
 * 1.下边节点的引用
 * 2.右边节点的引用
 */
public class Node {

    private Data data;
    private Node Right;
    private Node down;

    public Node() {
        this(null, null, null);
    }

    public Node(Data data) {
        this(data, null, null);
    }

    public Node(Data data, Node right, Node down) {
        super();
        this.data = data;
        Right = right;
        this.down = down;
    }

    public Data getData() {
        return data;
    }

    public Node getRight() {
        return Right;
    }

    public void setRight(Node right) {
        Right = right;
    }

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }

}
