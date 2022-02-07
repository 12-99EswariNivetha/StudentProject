package com.student.exception;

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

    public static class AccessFailedException extends CustomException {

        public AccessFailedException(String msg) {
            super(msg);
            // TODO Auto-generated constructor stub
        }
    }
}
