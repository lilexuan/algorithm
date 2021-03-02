package util;

/**
 * @author kelvin
 * @create 2021-03-02 10:38
 */

@FunctionalInterface
public interface FunctionCaller<T> {
    void call(T t);
}
