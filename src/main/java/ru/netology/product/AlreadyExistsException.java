package ru.netology.product;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String m) {
        super(m);
    }
}
