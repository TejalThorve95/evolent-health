package com.example.evolent.common;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<I, O> {
    O convert(I input);

    default List<O> convert(List<I> inputs) {
        return inputs.stream().map(this::convert).collect(Collectors.toList());
    }
}
