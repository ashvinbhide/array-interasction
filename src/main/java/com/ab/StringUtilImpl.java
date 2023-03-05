package com.ab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class StringUtilImpl implements StringUtil{

    private static final Logger logger = LoggerFactory.getLogger(StringUtilImpl.class);

    @Override
    public Number[] getNumsArray(String dataType,String data)  throws NumberFormatException{

        switch (dataType) {
            case "int":
            case "Integer":
                return intToInteger(data);

            case "long":
            case "Long":
                return longToLong(data);

            case "double":
            case "Double":
                return  doubleToDouble(data);

            default:
                logger.error(Constants.INVALID_ARGS);
                return null;

        }

    }

    private Number[] intToInteger(String data) throws NumberFormatException{
        int[] numbers =Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(numbers)
                .boxed()
                .toArray(Integer[]::new);
    }
    private Number[] longToLong(String data) throws NumberFormatException {
        long[] numbers2 = Arrays.stream(data.split(",")).mapToLong(Long::parseLong).toArray();
        return Arrays.stream(numbers2)
                .boxed()
                .toArray(Long[]::new);
    }

    private Number[] doubleToDouble(String data) throws NumberFormatException {
        double[] numbers3 = Arrays.stream(data.split(",")).mapToDouble(Double::parseDouble).toArray();
        return Arrays.stream(numbers3)
                .boxed()
                .toArray(Double[]::new);
    }
}
