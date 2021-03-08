package com.lms.utilities;

public class ErrorResponse {
    private Integer statuscode = null;

    private String message = null;

    public ErrorResponse(Integer statuscode, String message) {
        this.statuscode = statuscode;
        this.message = message;
    }

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
