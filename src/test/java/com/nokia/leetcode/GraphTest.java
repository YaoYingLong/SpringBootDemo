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

}
