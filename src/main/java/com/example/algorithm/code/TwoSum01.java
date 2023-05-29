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
        //将原始数据放入Map中key为值，value为下标
        HashMap<Integer, Integer> dataMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dataMap.put(nums[i], i);
        }
        int[] result = new int[]{};
        int resultNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > target) {
                break;
            }
            //目标值减当前数组值，判断map是否有
            if (dataMap.containsKey(target - num)) {
                result[resultNum++] = dataMap.get(target - num);
                result[resultNum++] = dataMap.get(num);
                dataMap.remove(num);
            }
        }
    }
}
