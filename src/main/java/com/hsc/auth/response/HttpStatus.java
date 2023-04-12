package com.hsc.auth.response;

import javax.xml.transform.OutputKeys;

public enum HttpStatus {
    OK(200, "OK"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    NOT_FOUND(404, "NOT_FOUND"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR");
    int code;
    String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
