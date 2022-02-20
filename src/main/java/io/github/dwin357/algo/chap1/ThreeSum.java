package io.github.dwin357.algo.chap1;

import java.util.Arrays;

public class ThreeSum {

    public static int doubleForLoopIntoBinarySearch(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        int k;
        for(int i=0; i<n; ++i) {
            for(int j=i+1; j<n; ++j){
                k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if(k>j){
                    ++count;
                }
            }
        }
        return count;
    }

    public static int naiveTripleForLoop(int[] a) {
        int n = a.length;
        int count = 0;
        for(int i=0; i<n; ++i) {
            for(int j=i+1; j<n; ++j) {
                for(int k=j+1; k<n; ++k){
                    if((a[i]+a[j]+a[k]) ==0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int singleForLoopIntoMarchToTheMiddle(int[] nums){
        Arrays.sort(nums);
        int count = 0;

        // some reusable var; recycle kids
        int leftPointer;
        int rightPointer;
        int positionSum;
        int lastIndex = nums.length-1;

        // for each element (which becomes the pivot point)
        for(int i=0; i<nums.length-2; i++) {

            leftPointer = i+1;
            rightPointer = lastIndex;
            while(rightPointer > leftPointer) {
                // this is pivot point at the heart of the solution
                positionSum = nums[i] + nums[leftPointer] + nums[rightPointer];

                // the conditional logic surrounding the piviot
                if( positionSum == 0 ) {
                    count++;
                    // tick both in on match
                    rightPointer--;
                    leftPointer++;

                } else if(positionSum > 0) {
                    // if high, lower high num
                    rightPointer--;

                } else {
                    // otherwise it is low, raise the low num
                    leftPointer++;
                }
            }
        }
        return count;
    }
}
