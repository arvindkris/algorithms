package com.ak.algo.mergesort;

import java.util.Arrays;

public class MergeSort {

    private void mergeSort( int [] input ,int n) {
        if( n == 1) return;
        int mid = n/2;
        int [] l = Arrays.copyOfRange(input, 0,mid);
        int [] r = Arrays.copyOfRange(input, mid,n);

        /*Arrays.stream(l).forEach(System.out::println);
        System.out.println("printed left\t");
        Arrays.stream(r).forEach(System.out::println);
        System.out.println("printed right\t");
        System.out.println("Done for N\t" + n + "\tmid\t" + mid);*/
        mergeSort(l,mid);
        mergeSort(r,n-mid);

        merge(input,l,r,mid,n-mid);


    }

    private void merge( int [] output, int [] l, int [] r,int left, int right) {
        int i=0,j=0, k=0;
        //each loop
        //1-check loop condition 2-check which if block to execute , 3- populate output & increment i or j
        //4. increment k - so total of 4 operations
        while (i < left || j < right){
           if(i>=left) output[k++]=r[j++];
           else if(j>=right) output[k++]=l[i++];
           else if(l[i] < r[j]) output[k++]=l[i++];
           else output[k++]=r[j++];
        }

    }

    public static void main(String[] args) {
        int[] input = new int[]{9,5,4,1,8,7,2,6,3};
        System.out.println("before sort\t");
        Arrays.stream(input).forEach(System.out::println);
        MergeSort sort = new MergeSort();
        sort.mergeSort(input,input.length);
        System.out.println("after sort\t");
        Arrays.stream(input).forEach(System.out::println);
    }
}
