package com.Kidou.exceptions;

import java.util.List;

public class ResponseBodyBeanValidation {

    private List<String> erros;

    public ResponseBodyBeanValidation(List<String> erros) {
        this.erros = erros;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }
}
