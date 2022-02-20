package io.github.dwin357.algo.chap1;

import edu.princeton.cs.algs4.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class ThreeSumFastTest {

//    @Test
    void tripleNestedForLoop() {
        /*
         *        n     sec
         *      250     0.0
                500     0.0
               1000     0.2
               2000     1.2
               4000    10.0
               8000    78.5
         */
        DoublingTest.main(new String[0]);
    }

//    @Test
    void doubleNestedForPlusBinarySearch() {
        /*
         *  Had to bump the value range from +/- 1M to +/- 700M to make unique array over 4k
                250     0.0
                500     0.0
               1000     0.0
               2000     0.0
               4000     0.2
               8000     0.7
              16000     3.1
         */


        int n = 250;

        while(true) {
            try {
                int[] a = new int[n];

                for(int i = 0; i < n; ++i) {
                    a[i] = StdRandom.uniform(-700_000_000, 700_000_000);
                }


                Stopwatch timer = new Stopwatch();
                ThreeSumFast.count(a);
                double time = timer.elapsedTime();
                StdOut.printf("%7d %7.1f\n", new Object[]{n, time});
                n += n;
            } catch (IllegalArgumentException dupe) {
                // do nothing ... just try again
            }

        }

    }

//    @Test
    void forLoopPlusMarchToTheMiddle() {
        /*
            250:     0     0.0
            500:     0     0.0
           1000:     0     0.0
           2000:     0     0.0
           4000:     5     0.0
           8000:    36     0.1
          16000:   357     0.4
          32000:  2934     1.6
          64000: 23479     6.2
         128000:187007    25.1
         */


        int n = 250;

        while(true) {
            try {
                int[] a = new int[n];

                for(int i = 0; i < n; ++i) {
                    a[i] = StdRandom.uniform(-700_000_000, 700_000_000);
                }


                Stopwatch timer = new Stopwatch();
                int c = MarchToTheMiddle.count(a);
                double time = timer.elapsedTime();
                StdOut.printf("%7d:%6d %7.1f\n", new Object[]{n, c,time});
                n += n;
            } catch (IllegalArgumentException dupe) {
                // do nothing ... just try again
            }

        }
    }


    /*
     *  So ya, march is actually stupid good
     *
     *   Count       Naive        Fast       March
            250  -1:   -1.0   0:    0.0   0:    0.0
            500  -1:   -1.0   0:    0.0   0:    0.0
           1000  -1:   -1.0   0:    0.0   0:    0.0
           2000  -1:   -1.0   0:    0.0   0:    0.0
           4000  -1:   -1.0   9:    0.2   9:    0.0
           8000  -1:   -1.0  51:    0.8  51:    0.1
          16000  -1:   -1.0 344:    3.1 344:    0.3
          32000  -1:   -1.0 2940:   12.6 2940:    1.2
     */


    //    @Test
    void sideBySide() {
        int n = 250;

        StdOut.printf("%7s %11s %11s %11s\n", new Object[]{"Count", "Naive", "Fast", "March"});
        while(true) {
            try {
                int[] a = new int[n];

                for(int i = 0; i < n; ++i) {
                    a[i] = StdRandom.uniform(-700_000_000, 700_000_000);
                }

                int[] copyOne = Arrays.copyOf(a, a.length);
                int[] copyTwo = Arrays.copyOf(a,a.length);


//                Stopwatch sn = new Stopwatch();
//                int nc = ThreeSum.count(a);
//                double nt = sn.elapsedTime();
                int nc = -1;
                double nt = -1;

                Stopwatch fn = new Stopwatch();
                int fc = ThreeSumFast.count(copyOne);
                double ft = fn.elapsedTime();

                Stopwatch mn = new Stopwatch();
                int mc = MarchToTheMiddle.count(copyTwo);
                double mt = mn.elapsedTime();

                StdOut.printf("%7d %3d:%7.1f %3d:%7.1f %3d:%7.1f\n", new Object[]{n, nc,nt,fc,ft,mc,mt});
                n += n;
            } catch (IllegalArgumentException dupe) {
                // do nothing ... just try again
            }

        }
    }
}