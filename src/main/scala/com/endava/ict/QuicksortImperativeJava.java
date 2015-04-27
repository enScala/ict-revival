package com.endava.ict;

public class QuicksortImperativeJava {

    public int[] array;

    public QuicksortImperativeJava(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        sort1(0, array.length - 1);
        return array;
    }

    public void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public void sort1(int l, int r) {
        int pivot = array[(l + r) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (array[i] < pivot) i += 1;
            while (array[j] > pivot) j -= 1;
            if (i <= j) {
                swap(i, j);
                i += 1;
                j -= 1;
            }
        }
        if (l < j) sort1(l, j);
        if (j < r) sort1(i, r);
    }

}
