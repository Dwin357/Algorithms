package io.github.dwin357.algo.chap1;

import java.util.Arrays;

public class MarchToTheMiddle {
    private MarchToTheMiddle(){}

    private static boolean containsDuplicates(int[] a) {
        for(int i = 1; i < a.length; ++i) {
            if (a[i] == a[i - 1]) {
                return true;
            }
        }

        return false;
    }

    /*
     * This method is copied from fast three some & only code in the else-block is changed
     * So both classes check for dupes in the same way and neither is advantaged
     */
    public static int count(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (containsDuplicates(nums)) {
            throw new IllegalArgumentException("array contains duplicate integers");
        } else {
            int count = 0;

            // some reusable var; recycle kids
            int leftPointer;
            int rightPointer;
            int positionSum;
            int lastIndex = nums.length-1;

            // for each element (which becomes the pivot point)
            for(int i=0; i<nums.length-2; i++) {
                // he did a thing I thought was clever, rather than dealing w/ dupes using the set-stuff I was doing
                // he took advantage of the sorted nature of the underlying to do a look-back ck & skip repeated el
                if(i !=0 && nums[i] == nums[i-1]) {
                    continue;
                }

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

                        // and move past dups if you are ever on them
                        while(rightPointer != lastIndex &&
                                rightPointer > leftPointer &&
                                nums[rightPointer] == nums[rightPointer+1]) {
                            rightPointer--;
                        }
                        // don't need to guard index out of bounds b/c i will always be behind left pointer
                        while (leftPointer < rightPointer &&
                                nums[leftPointer] == nums[leftPointer-1]) {
                            leftPointer++;
                        }

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
}
