package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,3,6,8,5,8,9,4,3,5};
        ArrayList<Map.Entry<Integer, Integer>> output = getIncreasingRangePairs(nums);
        System.out.println(output.toString());
    }

    public static ArrayList<Map.Entry<Integer, Integer>> getIncreasingRangePairs(int[] nums){
        ArrayList<Map.Entry<Integer, Integer>> pairs = new ArrayList<>();
        PairHolder pairHolder = null;
        for (int i=0; i<nums.length; i++){
            if (pairHolder == null){
                pairHolder = new PairHolder(i, nums[i]);
            }

            pairHolder.processNum(i, nums[i], i == nums.length-1);
            if (pairHolder.hasValidPair()){
                pairs.add(pairHolder.getPair());
                pairHolder = new PairHolder(i, nums[i]);
            }
            if (pairHolder.isInvalid()){
                pairHolder = new PairHolder(i, nums[i]);
            }
        }
        if (pairHolder != null && pairHolder.hasValidPair()){
            pairs.add(pairHolder.getPair());
        }
        return pairs;
    }
}
