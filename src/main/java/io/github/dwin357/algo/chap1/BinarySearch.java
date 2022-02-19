package io.github.dwin357.algo.chap1;

public class BinarySearch {

    /*
     * Evaluation Complexity: log n
     * Space Complexity: +0 (in place)
     * Limitation: must be done on a sorted ary
     *
     * Discussion:
     *  As a bit of a digression,
     *      The ancient greeks really didn't like infinite sets.  One paradox they devised goes as follows.  Say a
     *      person wants to walk to the end of a path, a distance of 30m.  Well logically they must first walk half the
     *      distance to their goal (15m).  And furthermore, before they can accomplish that intermediate-goal, they must
     *      first walk half the distance to it (7.5m).  And so, by recursively injecting an intermediate-goal between
     *      ourselves & whatever goal we are currently trying to accomplish, we not only make it impossible to complete
     *      our ultimate goal --but we even make it impossible begin the task by not having completed the prerequisites.
     *
     *      The fallacy of the paradox is that, while we may create an infinite number of intermediary steps, these
     *      intermediary steps are not weighted the same in terms of difficulty to accomplish, and in fact these weights
     *      very quickly converge to zero.  Is there a meaningful difference between me moving 1nm vs 2nm?  I probably
     *      move that much all the time in all different directions without ever realizing it or meaning to.
     *
     *  Binary search takes this core idea and turns it into an algorithm by recursively asking, "is the number I am
     *  looking for higher or lower than the middle number of a given range"; if higher re-ask your question on the top
     *  half of the former range, if lower re-ask for the bottom half, either way every time you ask you divide the
     *  search range you are considering in half (or a little less if you exclude the pivot point).
     *
     *  This recursive division by 2 on every pass is what gives the algorithm its log<2>(n) evaluation complexity.
     *  However, this is also where the weakness of needing to be on a sorted ary comes from, b/c the sorted nature of
     *  the ary creates a relationship between an element and all the elements to its right/left & this relationship is
     *  what we use come to a conclusion about big swaths of the ary without actually looking at the individual elements
     */

    public static int indexOf(int[] sortedAry, int target) {
        // initialize your 3 pointers
        int low = 0;
        int high = sortedAry.length-1;
        int mid;

        /*
         * This has 2 break conditions
         * a) you land on the target number (the else clause), in which case rtn that index and complete
         * b) your 2 boundary pointers cross (the while loop ck), in which case send the "not found" signal
         */
        while(low <= high) {
            /*
             * The difference between the high & low is the operational range,
             * We want the midpoint of that (so divide by 2),
             * but this then needs to be offset by the low amount (+low),
             * b/c everything less than the low amount we aren't considering.
             */
            mid = low + ((high - low) / 2);

            /*
             * if our evaluated point is above the target, we need to look at smaller numbers.
             * we do this by dropping high to 1 below the evaluated point (which we now know was too much)
             */
            if(sortedAry[mid] > target) {
                high = mid -1;

            /*
             * similarly, if our eval point is bellow the target, we need to look at bigger numbers
             */
            } else if(sortedAry[mid] < target) {
                low = mid + 1;

            /*
             * implicitly this is the same as sortedAry[mid] == target
             * this is our first break condition, a hit
             */
            } else {
                return mid;
            }
        }
        // the result when our second (miss) break condition is achieved
        return -1;
    }
}
