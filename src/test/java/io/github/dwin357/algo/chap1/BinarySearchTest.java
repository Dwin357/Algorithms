package io.github.dwin357.algo.chap1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void executionTest() {
        // data
        int[] allowed = new In("tinyAllowlist.txt").readAllInts();
        Arrays.sort(allowed);

        In data = new In("tinyText.txt");

        int[] actual = new int[3];
        int[] expected = new int[]{50,99,13};

        // tested act
        int key;
        int i = 0;
        while(data.hasNextLine()) {
            key = data.readInt();
            if(BinarySearch.indexOf(allowed, key) == -1) {
                actual[i++] = key;
            }
        }

        // assertion
        assertArrayEquals(expected,actual);

        // clean up
        data.close();
    }

    @Test
    void performanceTest() {
        // data
        int[] allowed = new In("largeAllowlist.txt").readAllInts();
        Arrays.sort(allowed);

        In data = new In("largeText.txt");

        int actual = 0;
        int expected = 367966;
        double actualTime; // 7.81800, 8.02800, 7.95100, 7.80700, 7.84700
        double expectedTime = 8.25;

        // tested act
        Stopwatch watch = new Stopwatch();
        int key;
        while(data.hasNextLine()) {
            try{
                key = data.readInt();
            } catch (NoSuchElementException grr) {
                break;
            }
            if(BinarySearch.indexOf(allowed, key) == -1) {
                actual++;
            }
        }
        actualTime = watch.elapsedTime();

        // assertions
        assertEquals(expected,actual);
        assertTrue(expectedTime > actualTime,String.format("expected:%.5f actual:%.5f", expectedTime,actualTime));
    }

}