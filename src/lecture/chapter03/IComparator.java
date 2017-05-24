package lecture.chapter03;

public interface IComparator {
    // < 0: data1 < data2, 
    // = 0: data1 = data2,
    // > 0: data1 > data2
    int compare(Object data1, Object data2);

    // < 0: data < key, 
    // = 0: data = key, 
    // > 0: data > key
    int compare(Object data, IKey key);
}
