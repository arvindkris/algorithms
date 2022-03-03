package com.ak.algo.mergesort;

import java.util.Arrays;

public class MergeSort_1 {
    private void mergeSort( int [] input, int start, int end) {
        System.out.println("Merge SORT \t" + start + "\t" + end);
        if( start < end) {
            int mid = (start + end) /2;
            mergeSort(input, start, mid);
            mergeSort(input, mid + 1, end);
            merge(input, start,mid,end);

        }
    }

    private void merge(int [] input, int start, int mid, int end) {
        int p = start, q= mid+1, k =0;
        int [] Arr= new int[end-start+1];
        System.out.println(start + "\t" + mid + "\t" + end);

        for(int i = start;i <=end;i++) {
            if(p>mid) Arr[k++]=input[q++];
            else if(q>end) Arr[k++]=input[p++];
            else if(input[p] < input[q]) Arr[k++]=input[p++];
            else Arr[k++]=input[q++];
        }
        Arrays.stream(Arr).forEach(System.out::println);
        System.out.println("printed Array *********");
        for (p=0 ; p< k ;p ++) {
            input[ start++ ] = Arr[ p ] ;
        }
        System.out.println("modified Input Array Printing*********");
        Arrays.stream(input).forEach(System.out::println);
        System.out.println("modified Input Array Printed^^^^^^^^^^^^^^^^^");

    }

    public static void main(String[] args) {
        int[] input = new int[]{5,4,1,8,7,2,6,3};

        System.out.println("before sort\t");
        Arrays.stream(input).forEach(System.out::println);
        MergeSort_1 sort = new MergeSort_1();
        sort.mergeSort(input,0,input.length -1);
        System.out.println("after sort\t");
        Arrays.stream(input).forEach(System.out::println);
    }


}
