package com.ab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Number[] first = new Number[0];
        Number[] second = new Number[0];
        validateArgs(args);

        StringUtilImpl stringUtil = new StringUtilImpl();
        try {
            first = stringUtil.getNumsArray(args[0], args[1]);
            second = stringUtil.getNumsArray(args[0], args[2]);
        }catch (NumberFormatException e) {
            logger.error(Constants.INVALID_ARGS);
            System.exit(0);
        }

        logger.info(Constants.START);
        CollectionUtilsImpl collectionUtils = new CollectionUtilsImpl();
        collectionUtils.printNumArray(first);
        collectionUtils.printNumArray(second);
        Set res1 = collectionUtils.findIntersection(first, second);
        logger.info(Constants.RESULT+res1);

        logger.info(Constants.END);
    }

    private static void validateArgs(String[] args) {
        if(args.length!=3) {
            logger.error(Constants.INVALID_ARGS);
            System.exit(0);
        }
    }
}
