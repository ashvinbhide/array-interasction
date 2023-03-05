package com.ab;

import java.util.Set;

public interface CollectionUtils<T extends Number> {

    Set<T> findIntersection(T[] a, T[] b);
    void printNumArray(T[] arr);
}
