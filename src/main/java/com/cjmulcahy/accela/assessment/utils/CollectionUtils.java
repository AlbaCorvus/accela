package com.cjmulcahy.accela.assessment.utils;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionUtils {

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }
}
