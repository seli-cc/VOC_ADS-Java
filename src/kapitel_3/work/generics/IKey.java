package kapitel_3.work.generics;

public interface IKey<T> {
    boolean matches(T data); // Return true if the key matches a given object.
}
