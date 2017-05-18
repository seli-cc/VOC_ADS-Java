package vl.chapter04.tests;

import vl.chapter03.IComparator;
import vl.chapter03.SearchTree;
import vl.chapter03.tests.IntegerComparator;
import vl.chapter03.utils.PGFTreePrinter;

public class TestSearchTree {
    public static void main(String[] args) {
        IComparator iComparator = new IntegerComparator();

        SearchTree searchTree = new SearchTree(iComparator);

        int[] array = {5, 3, 7, 4, 2, 6, 8};

        for(int i = 0; i < array.length; i++) {
            searchTree.insert(array[i]);
        }
        PGFTreePrinter ptp = new PGFTreePrinter(searchTree);
        
        System.out.println(ptp);
    }
}
