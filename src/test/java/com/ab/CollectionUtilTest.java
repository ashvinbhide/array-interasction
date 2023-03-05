package com.ab;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CollectionUtilTest {


    private static Stream<Arguments> numberList() {
        return Stream.of(
                arguments(new Integer[]{1,2,2,1},2),
                arguments(new Double[] {2.0,3.0},2),
                arguments(new Number[]{9,4,9,8,4},3)
        );
    }

    @ParameterizedTest
    @MethodSource("numberList")
    public void addAllToSetTest(Number[] numList, int result) {

        CollectionUtilsImpl collectionUtils = new CollectionUtilsImpl();

        Set set = collectionUtils.addAllToSet(numList);
        assertTrue(set.size() == result);
    }

    private static Stream<Arguments> setAndArray() {
        return Stream.of(

                arguments(Stream.of(2,2).collect(Collectors.toCollection(HashSet::new)),new Integer[]{1,2,2,1},1),
                arguments(Stream.of(4.0,9.0,5.0).collect(Collectors.toCollection(HashSet::new)),new Double[] {2.0,3.0},0),
                arguments(Stream.of(9,4,9).collect(Collectors.toCollection(HashSet::new)),new Number[]{9,4,9,8,4},2),
                arguments(null,new Number[]{},0)
        );
    }

    @ParameterizedTest
    @MethodSource("setAndArray")
    public void getIntersectionTest(Set<Number>set ,Number[]arr, int result ) {
        CollectionUtilsImpl collectionUtils = new CollectionUtilsImpl();
        Set<Number> res = collectionUtils.getIntersection(set,arr);
        System.out.println(res.size());

    }
}
