package io.github.dwin357.algo.util;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TimeTrials {

    public static void main(String[] args) {

    }



    public static BiFunction<Integer,Integer,int[]> RANDOM_INT_ARY = (max,n) -> {
        int[] data = new int[n];
        for(int i=0; i<n; i++) {
            data[i] = StdRandom.uniform(0, max);
        }
        return data;
    };

    public static <Input> double timeTrial(Supplier<Input> input, Consumer<Input> func) {
        Input data = input.get();
        Stopwatch watch = new Stopwatch();
        func.accept(data);
        return watch.elapsedTime();
    }

}
