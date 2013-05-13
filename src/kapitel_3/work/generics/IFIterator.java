package kapitel_3.work.generics;

public interface IFIterator<T> {
    boolean hasNext(); // Does a further object exist?
    T next();     // Return the next object.
}
