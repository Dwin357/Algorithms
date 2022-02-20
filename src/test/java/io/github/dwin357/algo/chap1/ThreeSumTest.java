package io.github.dwin357.algo.chap1;

import edu.princeton.cs.algs4.StdDraw;
import io.github.dwin357.algo.util.TimeTrials;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @Test
    void threeWayCompare() throws InterruptedException {

        int seed = 250;
        int cycles = 4;
        int range = 700_000_000;

        StdDraw.setXscale(-0.05,cycles-0.95);
        StdDraw.setYscale(-0.01,1);
        StdDraw.setPenRadius(0.01);

        int n = seed;
        for(int trial=0; trial < cycles; trial++){

            final int[] a = TimeTrials.RANDOM_UNIQ_INT_ARY.apply(range,n);
            final int[] b = Arrays.copyOf(a,n);
            final int[] c = Arrays.copyOf(a,n);

            StdDraw.setPenColor(Color.RED);
            StdDraw.point(
                    trial,
                    TimeTrials.timeTrial(()->a, ThreeSum::naiveTripleForLoop)
            );
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.point(
                    trial,
                    TimeTrials.timeTrial(()->b, ThreeSum::doubleForLoopIntoBinarySearch)
            );
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.point(
                    trial,
                    TimeTrials.timeTrial(()->c, ThreeSum::singleForLoopIntoMarchToTheMiddle)
            );
            n += n;
        }

        Thread.sleep(15000);
    }

    @Test
    void twoWayCompare() throws InterruptedException {

        int seed = 250;
        int cycles = 7;
        int range = 700_000_000;

        StdDraw.setXscale(-0.05,cycles-0.95);
        StdDraw.setYscale(-0.01,1);
        StdDraw.setPenRadius(0.01);

        int n = seed;
        for(int trial=0; trial < cycles; trial++){

            final int[] a = TimeTrials.RANDOM_UNIQ_INT_ARY.apply(range,n);
            final int[] b = Arrays.copyOf(a,n);


            StdDraw.setPenColor(Color.BLUE);
            StdDraw.point(
                    trial,
                    TimeTrials.timeTrial(()->b, ThreeSum::doubleForLoopIntoBinarySearch)
            );
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.point(
                    trial,
                    TimeTrials.timeTrial(()->a, ThreeSum::singleForLoopIntoMarchToTheMiddle)
            );
            n += n;
        }

        Thread.sleep(15000);
    }
}