package kapitel_3.tests;

import kapitel_3.work.generics.IComparator;
import kapitel_3.work.generics.IKey;

public class IntegerComparatorGeneric implements IComparator<Integer> {
    public int compare(Integer data1, Integer data2) {
        int int1 = (Integer) data1;
        int int2 = (Integer) data2;
        
        if (int1 < int2) {
            return -1;
        } else if (int1 == int2) {
            return 0;
        } else { 
            return 1;
        }
    }

    public int compare(Integer data, IKey<Integer> key) {
        int int1 = (Integer) data;
        int int2 = (Integer) ((IntegerKeyGeneric) key).data;
        
        if (int1 < int2) {
            return -1;
        } else if (int1 == int2) {
            return 0;
        } else { 
            return 1;
        }
    }
}
