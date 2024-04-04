package com.Kidou.exceptions;


import org.springframework.http.HttpStatus;

import java.util.Date;

public class ResponseBody {

    private String erro;
    private Date date;
    private HttpStatus status;

    public ResponseBody() {
    }

    public ResponseBody(String erro, Date date, HttpStatus status) {
        this.erro = erro;
        this.date = date;
        this.status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
