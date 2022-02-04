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
    
    public static class InputMismatchException extends CustomException {

        public InputMismatchException(String msg) {
            super(msg);
        }
    }
    
}
