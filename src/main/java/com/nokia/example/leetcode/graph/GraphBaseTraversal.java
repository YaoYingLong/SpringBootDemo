package com.nokia.example.leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
}