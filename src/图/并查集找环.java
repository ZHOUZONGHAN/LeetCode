package 图;

/**
 * @author zhouzh6
 * @date 2020-09-27
 */
public class 并查集找环 {

    private static void initParent(int[] parent, int[] rank) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
            rank[i] = 0;
        }
    }

    private static int findRoot(int x, int[] parent) {
        int xRoot = x;
        while (parent[xRoot] != -1) {
            xRoot = parent[xRoot];
        }
        return xRoot;
    }

    /**
     *
     * @param x
     * @param y
     * @param parent
     * @return 返回1表示合并成功，返回0表示合并失败
     */
    private static int unionRoot(int x, int y, int[] parent, int[] rank) {
        int xRoot = findRoot(x, parent);
        int yRoot = findRoot(y, parent);
        if (xRoot == yRoot) {
            return 0;
        } else {
            if (rank[xRoot] > rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] < rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[xRoot] = yRoot;
                rank[yRoot]++;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        int nodeSize = 5;
        int[] parent = new int[nodeSize];
        int[] rank = new int[nodeSize];
        initParent(parent, rank);

        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {2, 4}};

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (unionRoot(x, y, parent, rank) == 0) {
                System.out.println("CYCLE");
                return;
            }
        }
        System.out.println("NO CYCLES");
    }
}
