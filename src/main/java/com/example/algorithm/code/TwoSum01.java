package com.example.algorithm.code;

import java.util.HashMap;

/*************************************************************************
 ******
 * - Copyright (c) 2023 shangzhao.com
 * - File Name: TwoSum01
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2023/3/1   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class TwoSum01 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            int a = target - nums[i];
            if (hashMap.containsKey(a)) {
                resultMap.put(i, hashMap.get(a));
                hashMap.remove(nums[i]);
            }
        }
        System.out.println(resultMap);
    }
}
