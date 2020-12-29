package com.nokia.leetcode;

import com.nokia.example.leetcode.graph.GraphDSUTraversal;
import org.junit.Test;

/**
 * @author by YingLong on 2020/12/16
 */
public class GraphDSUTraversalTest {

    @Test
    public void regionsBySlashesTest() {
        GraphDSUTraversal graphDSUTraversal = new GraphDSUTraversal();
        String[] grid = new String[]{"\\/", "/\\"};
        graphDSUTraversal.regionsBySlashes(grid);
    }

}
