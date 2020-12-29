package com.nokia.example.leetcode.graph;

/**
 * 通过并查集的方式
 *
 * @author by YingLong on 2020/12/16
 */
public class GraphDSUTraversal {

    /**
     * 959. 由斜杠划分区域
     * <p>
     * 创建 4*N*N 个顶点，每个代表一个三角形，按照如上的方式连接它们。然后使用并查集算法找到连通块的总数。
     * 这里将每个最小的正方形分成是个小三角形，并对每个小三角形进行编号标记，这里的编号顺序是：上0，下3，左1，右2
     *
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        DSU dsu = new DSU(4 * N * N);
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                int root = 4 * (r * N + c);
                char val = grid[r].charAt(c);
                if (val != '\\') {
                    dsu.union(root + 0, root + 1);
                    dsu.union(root + 2, root + 3);
                }
                if (val != '/') {
                    dsu.union(root + 0, root + 2);
                    dsu.union(root + 1, root + 3);
                }

                if (r + 1 < N) {
                    dsu.union(root + 3, (root + 4 * N) + 0);
                }
                if (c + 1 < N) {
                    dsu.union(root + 2, (root + 4) + 1);
                }
            }
        }
        int ans = 0;
        for (int x = 0; x < 4 * N * N; ++x) {
            if (dsu.find(x) == x) {
                ans++;
            }
        }
        return ans;
    }


    class DSU {
        int[] parent;

        public DSU(int N) {
            parent = new int[N];
            for (int n = 0; n < N; ++n) {
                parent[n] = n;
            }
        }

        public int find(int x) {
            return parent[x] == x ? x : find(parent[x]);
        }

        public int findCompress(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

}
