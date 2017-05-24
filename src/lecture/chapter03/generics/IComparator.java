package lecture.chapter03.generics;

public interface IComparator<T> {
    // < 0: data < key, 
    // = 0: data = key, 
    // > 0: data > key
    int compare(T data1, T data2);

    // < 0: data < key, 
    // = 0: data = key, 
    // > 0: data > key
    int compare(T data, IKey<T> key);
}
