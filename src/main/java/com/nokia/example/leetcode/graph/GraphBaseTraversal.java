package com.nokia.example.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

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

}
