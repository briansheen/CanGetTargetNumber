package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(5);
        nums.add(3);
        nums.add(8);
        nums.add(4);
        nums.add(10);
        int target = 10;
        System.out.println(canGetTarget(nums, target));
    }

    public static boolean canGetTargetBruteForce(List<Integer> nums, int target){
        for(int i = 0; i < nums.size(); ++i){
            for(int j = i + 1; j < nums.size(); ++j){
                if((nums.get(i)+nums.get(j))==target){
                    System.out.println(nums.get(i));
                    System.out.println(nums.get(j));
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canGetTarget(List<Integer> nums, int target){
        Set<Integer> numsSet = new HashSet<>();
        numsSet.add(nums.get(0));
        int difference = 0;
        for(int i = 0; i < nums.size(); ++i){
            if(target > nums.get(i)){
                difference = target - nums.get(i);
            } else {
                difference = nums.get(i) - target;
            }
            if(numsSet.contains(difference)){
                return true;
            }
            if(!numsSet.contains(nums.get(i))){
                numsSet.add(nums.get(i));
            }
        }
        return false;
    }
}
