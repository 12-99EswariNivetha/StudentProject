package com.exception;

@SuppressWarnings("serial")
public class RecordNotfoundException extends Exception {

    public RecordNotfoundException() {
        super();
    }

    public RecordNotfoundException(String msg) {
        super(msg);
    }

}
