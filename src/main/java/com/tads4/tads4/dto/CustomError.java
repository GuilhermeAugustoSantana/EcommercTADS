package com.tads4.tads4.dto;

import java.time.Instant;

public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String erro;
    private String path;

    public CustomError(Instant timestamp, Integer status, String erro, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.erro = erro;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }

    public String getPath() {
        return path;
    }
}
