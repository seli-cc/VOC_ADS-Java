package lecture.chapter03.tests;

import lecture.chapter03.generics.IComparator;
import lecture.chapter03.generics.IKey;

public class IntegerComparatorGeneric implements IComparator<Integer> {
    public int compare(Integer data1, Integer data2) {
        int int1 = data1;
        int int2 = data2;
        
        return int1 - int2;
    }

    public int compare(Integer data, IKey<Integer> key) {
        Integer int1 = data;
        Integer int2 = ((IntegerKeyGeneric) key).data;
        
        return compare(int1, int2);
    }
}
