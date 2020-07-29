package com.nokia.UT;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author by YingLong on 2020/2/26
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] resultArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int numOne = nums[i];
            int diff = target - numOne;
            for (int j = i + 1; j < nums.length; j++) {
                if (diff == nums[j]) {
                    resultArray[0] = i;
                    resultArray[1] = j;
                }
            }
        }
        return resultArray;
    }

    @Test
    public void towSumTest() {
        {
            int[] testArray = new int[]{2, 7, 11, 15};
            for (int i : this.twoSum(testArray, 9)) {
                System.out.println(i);
            }
        }
        {
            int[] testArray = new int[]{3, 3};
            for (int i : this.twoSum(testArray, 6)) {
                System.out.println(i);
            }
        }
//        System.out.println(this.twoSum(testArray, 13));
//        System.out.println(this.twoSum(testArray, 26));
    }
}
