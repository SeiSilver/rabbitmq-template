package com.consumerservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SystemMessage {

    private String message;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Date date;

    public SystemMessage(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public SystemMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SystemMessage{" +
                "message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
