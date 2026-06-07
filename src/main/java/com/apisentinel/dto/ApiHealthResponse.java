package com.apisentinel.dto;

public class ApiHealthResponse {

    private String status;
    private Long responseTime;

    public ApiHealthResponse() {
    }

    public ApiHealthResponse(String status, Long responseTime) {
        this.status = status;
        this.responseTime = responseTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }
}
