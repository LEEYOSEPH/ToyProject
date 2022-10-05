package com.toyproject.jpaBoard.board.exception;

public class JpaBoardException extends RuntimeException {

    public JpaBoardException(String message) {
        super(message);
    }

    public JpaBoardException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();
}
