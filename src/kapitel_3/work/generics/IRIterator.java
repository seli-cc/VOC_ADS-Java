package kapitel_3.work.generics;

public interface IRIterator<T> { // The Backward-iterator interface
    boolean hasPrevious(); // Does a prior object exist?
    T previous();     // Return the prior object.
}
