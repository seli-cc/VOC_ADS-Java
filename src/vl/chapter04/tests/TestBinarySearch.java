package vl.chapter04.tests;

import vl.chapter04.BinarySearch;

public class TestBinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 5, 5, 7, 9};
        
        int index = BinarySearch.binarySearch(array, 9);
        
        System.out.println(index);
    }
}
