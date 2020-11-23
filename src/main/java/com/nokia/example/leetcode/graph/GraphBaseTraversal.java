package com.nokia.example.leetcode.graph;

import java.util.*;

/**
 * @author by YingLong on 2020/9/3
 */
public class GraphBaseTraversal {

    /**
     * 1557
     * 可以到达所有点的最少点数目
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        for (List<Integer> edge : edges) {
            inDegree[edge.get(1)] = 1;
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    /**
     * 997
     * 找到小镇的法官
     *
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];
        for (int[] ints : trust) {
            inDegree[ints[1]]++;
            outDegree[ints[0]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public int findJudge2(int N, int[][] trust) {
        int[] degree = new int[N + 1];
        for (int[] ints : trust) {
            degree[ints[1]]++;
            degree[ints[0]]--;
        }
        for (int i = 1; i <= N; i++) {
            if (degree[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 1042
     * 不邻接植花
     *
     * @param N
     * @param paths
     * @return
     */
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] result = new int[N];
        List<Integer>[] adjTable = new ArrayList[N + 1];
        for (int i = 1; i < adjTable.length; i++) {
            adjTable[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            adjTable[path[0]].add(path[1]);
            adjTable[path[1]].add(path[0]);
        }

        for (int i = 1; i <= N; i++) {
            boolean[] hasColors = new boolean[5];
            for (Integer id : adjTable[i]) {
                hasColors[result[id - 1]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                if (!hasColors[j]) {
                    result[i - 1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 1387
     * 将整数按权重排序
     *
     * @param lo
     * @param hi
     * @param k
     * @return
     */
    public int getKth(int lo, int hi, int k) {
        TreeMap<Integer, List<Integer>> resultMap = new TreeMap<>();
        for (int i = lo; i <= hi; i++) {
            int weight = getWeight(i);
            List<Integer> subList = resultMap.getOrDefault(weight, new ArrayList<>());
            subList.add(i);
            resultMap.put(weight, subList);
        }
        int kth = 1;
        for (Integer weight : resultMap.keySet()) {
            List<Integer> nodeList = resultMap.get(weight);
            for (Integer node : nodeList) {
                if (k == kth) {
                    return node;
                }
                kth++;
            }
        }
        return -1;
    }

    public int getWeight(int k) {
        int weight = 0;
        while (k != 1) {
            if ((k & 1) == 1) {
                k = 3 * k + 1;
            } else {
                k /= 2;
            }
            weight++;
        }
        return weight;
    }

    /**
     * 1030
     * 距离顺序排列矩阵单元格
     * 思路：
     * - 由于输出是一个2列 R* C行的二维数组
     * - 所以先将矩阵转换为上面说得二维数组
     * - 再对二维数组中的数据排序
     *
     * @param R  - 矩阵的行
     * @param C  - 矩阵的列
     * @param r0 - 矩阵中点的横坐标
     * @param c0 - 矩阵中点的纵坐标
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, Comparator.comparingInt(o -> Math.abs(o[0] - r0) + Math.abs(o[1] - c0)));
        return ret;
    }
}
