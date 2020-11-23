package com.nokia.leetcode;

import com.nokia.example.leetcode.graph.GraphBaseTraversal;
import org.junit.Test;

/**
 * @author by YingLong on 2020/9/4
 */
public class GraphTest {

    @Test
    public void getKthTest() {
        GraphBaseTraversal traversal = new GraphBaseTraversal();
        System.out.println(traversal.getKth(12, 13, 2));
    }

    @Test
    public void allCellsDistOrderTest() {
        GraphBaseTraversal traversal = new GraphBaseTraversal();
        int[][] ret = traversal.allCellsDistOrder(5, 4, 2, 2);
        for (int i = 0; i < ret.length; i++) {
            for (int j = ret[i].length - 1; j >= 0; j--) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }

}
