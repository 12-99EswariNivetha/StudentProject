package com.exception;

public class CustomException extends RuntimeException {

    public CustomException(String msg) {
        super(msg);
    }

    public static class RecordNotfoundException extends CustomException {

        public RecordNotfoundException(String msg) {
            super(msg);
        }
    }

    public static class IdAlreadyFoundException extends CustomException {

        public IdAlreadyFoundException(String msg) {
            super(msg);
        }
    }

    public static class SqlQueryException extends CustomException {

        public SqlQueryException(String msg) {
            super(msg);
        }
    }
}
