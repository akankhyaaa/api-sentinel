package com.apisentinel.dto;

public class DashboardResponse {

    private long totalApis;
    private long upApis;
    private long downApis;
    private double successRate;

    public long getTotalApis() {
        return totalApis;
    }

    public void setTotalApis(long totalApis) {
        this.totalApis = totalApis;
    }

    public long getUpApis() {
        return upApis;
    }

    public void setUpApis(long upApis) {
        this.upApis = upApis;
    }

    public long getDownApis() {
        return downApis;
    }

    public void setDownApis(long downApis) {
        this.downApis = downApis;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }
}
