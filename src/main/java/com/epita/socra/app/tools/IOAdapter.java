package com.epita.socra.app.tools;

public interface IOAdapter {
    String read();

    int readInteger();

    void write(String message);
}
