package io.github.dwin357.algo.chap1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Average {

    public static void main(String[] args) {
        double sum = 0.0;
        int count = 0;
        while(!StdIn.isEmpty()){
            sum += StdIn.readDouble();
            count++;
        }
        double avg = sum / count;
        StdOut.printf("Average is %.5f\n", avg);
    }

    /*
     * Ya! I imported the lib correctly.
     * Also ctrl+d is needed to make it evaluate
     */
}
