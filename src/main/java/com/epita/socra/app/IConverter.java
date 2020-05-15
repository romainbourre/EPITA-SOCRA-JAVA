package com.epita.socra.app;

public interface IConverter {
    String convert(String value) throws InvalidArgumentException;
}
