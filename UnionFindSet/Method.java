package UnionFindSet;

/**
 * 参考资料：https://www.bilibili.com/video/BV13t411v7Fs?t=2&p=3
 */
public class Method {
    private final int COUNT = 6; // 点的数量
    private final int[] root = new int[COUNT];
    private final int[] rank = new int[COUNT];

    private int findRoot(int pos) {
        int posTmp = pos;
        while(root[posTmp]!=0) {
            posTmp = root[posTmp];
        }
        return posTmp;
    }

    private boolean union(int posX, int posY) {
        int rootX = findRoot(posX-1);
        int rootY = findRoot(posY-1);
        if (rootX == rootY) return false;
        else {
            if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else {
                root[rootX] = rootY;
                rank[rootX]++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Method method = new Method();

        int[][] data = new int[][]{
                {1,2}, {2,3}, {2,4},
                {4,5}, {3,6}, {3,4}
        };

        for (int[] node : data) {
            if (!method.union(node[0], node[1])) {
                System.out.println("Circle");
                return;
            }
        }

        System.out.println("no Circle");
    }
}
