package com.study.leetcode.july;

public class T冒泡快速排序 {

//    public static void main(String[] args) {
//
//        int[] nums = {5,1,3,8,7,9,6,4};
//
//        for (int i = 0; i < nums.length;i++){
//            for (int j = 0; j < nums.length-1-i;j++){
//                if (nums[j] > nums[j+1]){
//                    int temp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = temp;
//                }
//            }
//        }
//        System.out.println(nums);
//
//    }


    public static void main(String[] args) {
        int[] nums = {5,1,3,8,7,9,6,4};

        quickSort(nums, 0,nums.length -1);
        System.out.println(nums);
    }

    public static void quickSort(int[] arr, int left,int right){
        int pivot = arr[(left+right)/2];
        int temp;
        int l = left, r = right;
        while(l < r){
            while(arr[l] < pivot){
                l++;
            }
            while(arr[r] > pivot){
                r--;
            }
            if(l>=r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == pivot){
                r--;
            }

            if (arr[r] == pivot){
                l++;
            }
        }
        if (l == r){
            l++;
            r--;
        }
        if(left < r){
            quickSort(arr,left,r);
        }
        if(l < right){
            quickSort(arr,l,right);
        }
    }

}
