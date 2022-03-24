package br.com.server.location.usercases.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ValidationFieldException extends Exception {

    private String title;

    private String detail;

    private String message;

    private Integer status;

    private LocalDateTime time;

    public ValidationFieldException(String message) {
        super(message);
        this.message = message;
    }

    public ValidationFieldException(String detail, String message) {
        super();
        this.title = "Campo obrigatório ou invalido";
        this.detail = detail;
        this.message = message;
        this.status = HttpStatus.NOT_ACCEPTABLE.value();
        this.time = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}