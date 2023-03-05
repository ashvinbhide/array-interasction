package com.ab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CollectionUtilsImpl<T extends Number>  implements CollectionUtils<T> {

    private static final Logger logger = LoggerFactory.getLogger(CollectionUtilsImpl.class);

    public Set<T> findIntersection(T[] first, T[] second) {
        Set<T> set;
        Set<T> res ;
        if(first.length>second.length) {
            set = addAllToSet(second);
            res = getIntersection(set,second);
        }
        else  {
           set = addAllToSet(first);
            res = getIntersection(set,first);
        }

        return res;
    }

    public Set<T> addAllToSet(T[] arr) {
        return new HashSet<>(Arrays.asList(arr));
    }

    public Set<T> getIntersection(Set<T> set,T[] arr) {
        Set<T> res  = new HashSet<>();
        for (T var : arr) {
            if(set.contains(var)) {
                res.add(var);
            }
        }
        return res;
    }

    public void printNumArray(T[] arr) {

        StringBuilder sb = new StringBuilder(Constants.INPUT);
        for (T var:arr) {
          sb = sb.append("  "+var);
        }
        logger.info (sb.toString());
    }
}
