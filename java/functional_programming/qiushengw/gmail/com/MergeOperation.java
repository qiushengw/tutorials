package qiushengw.gmail.com;

/**
 * Any SAM ( single abstract method is functional method, can use lambda to do the implementation.
 *
 * @param <T>
 */
@FunctionalInterface
public interface MergeOperation<T> {
    T add(T a, T b);
}
