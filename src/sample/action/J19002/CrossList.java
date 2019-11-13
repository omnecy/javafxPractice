package sample.action.J19002;

/**
 *
 */
public class CrossList {

    /**
     * @cols原始矩阵的列数
     */
    private int cols;
    /**
     * @rows原始矩阵的行数
     */
    private int rows;
    /**
     * @nums原始矩阵中非零元素的个数
     */
    private int nums;
    /**
     * @rhead列指针----单纯的充当头指针，执行该行第一个非零元素，所以其长度等于cols
     */
    private Node[] rhead;
    /**
     * @chead行指针----单纯的充当头指针，执行该列第一个非零元素，其长度等于rows
     */
    private Node[] chead;

    public CrossList(int cols, int rows) {
        inintHeader(cols, rows);
    }

    /**
     * @param datas
     * @构造器
     * @Description: TODO(将一个数组变成一个稀疏矩阵存储的形式)
     */
    public CrossList(int[][] datas) {
        inintHeader(datas[0].length, datas.length);
        for (int row = 0; row < datas.length; row++) {
            for (int col = 0; col < datas[0].length; col++) {
                if (datas[row][col] != 0) {
                    insert(row, col, datas[row][col]);
                }
            }
        }
    }

    /**
     * @param row
     * @param col
     * @param data
     * @Description: TODO(在该稀疏矩阵中插入一个元素)
     */
    public void insert(int row, int col, int data) {
        this.nums++;
        // 创建一个十字链表结点，并将数据存储进去
        Data da = new Data(row, col, data);
        Node newNode = new Node(da);

        // 通过行列头指针，确定指向该新结点的指针
        Node t = rhead[row];// 找到该行的头指针
        while (t.getRight() != null) {// 找到该行的末尾
            t = t.getRight();
        }
        t.setRight(newNode);// 让该行的末尾指向该新结点
        //
        t = chead[col];
        while (t.getDown() != null) {
            t = t.getDown();
        }
        t.setDown(newNode);
    }

    /**
     * @Description: TODO(通过行数和列数 ， 初始化行列头指针)
     */
    public void inintHeader(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        rhead = new Node[cols];
        chead = new Node[rows];
        // 初始化行的头指针
        for (int i = 0; i < rhead.length; i++) {
            rhead[i] = new Node();
        }
        // 设置列的头指针
        for (int i = 0; i < chead.length; i++) {
            chead[i] = new Node();
        }
    }

    /**
     * @Description: TODO(遍历整个十字链表)
     */
    public StringBuilder print() {
        StringBuilder s = new StringBuilder("原始矩阵 共" + rows + "行, " + cols + "列， " + this.nums
                + "个非零元素\n");
        s.append("---------------------------------------\n");
        s.append("从行上来看\n");
        s.append("行号\n");
        for (int i = 0; i < rhead.length; i++) {
            s.append(i + "  ");
            Node t = rhead[i];
            while (t != null) {
                if (t.getData() != null) {// 头指针数据为空
                    s.append(t.getData().getValue() + "->");
                }
                t = t.getRight();
            }
            s.append("\n");
        }
        s.append("---------------------------------------\n");
        s.append("从列上来看\n");
        s.append("列号\n");
        for (int i = 0; i < chead.length; i++) {
            s.append(i + "  ");
            Node t = chead[i];
            while (t != null) {
                if (t.getData() != null) {
                    s.append(t.getData().getValue() + "->");
                }
                t = t.getDown();
            }
            s.append("\n");
        }

        return s;
    }

}
