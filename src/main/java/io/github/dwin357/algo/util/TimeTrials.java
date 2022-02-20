package io.github.dwin357.algo.util;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TimeTrials {


    public static BiFunction<Integer,Integer,int[]> RANDOM_UNIQ_INT_ARY = (range,n) -> {
        int[] data = new int[n];
        int[] assurance = new int[n];
        int count = 0;

        Stopwatch watch = new Stopwatch();
        gen:while(true) {
            count++;
            for(int i=0; i<n; i++) {
                data[i] = StdRandom.uniform(-range, range);
                assurance[i] = data[i];
            }
            Arrays.sort(assurance);
            for(int i=1; i<n; i++) {
                if(assurance[i] == assurance[i-1]) {
                    continue gen;
                }
            }
            break;
        }
        double time = watch.elapsedTime();

        System.out.printf("Generated uniq ary n:%d of +/-:%d in tries:%d time:%.3f\n",n,range,count,time);

        return data;
    };

    public static <Input> double timeTrial(Supplier<Input> input, Consumer<Input> func) {
        Input data = input.get();
        Stopwatch watch = new Stopwatch();
        func.accept(data);
        return watch.elapsedTime();
    }

}
