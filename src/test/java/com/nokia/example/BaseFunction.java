package com.nokia.example;

import java.util.function.Function;

/**
 * Created by YLongYao on 2016/10/8.
 */
public class BaseFunction<T , R> implements Function<T , R>{

    @Override
    public R apply(T t) {
        return null;
    }

    @Override
    public <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        return null;
    }

    @Override
    public <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        return null;
    }
}
