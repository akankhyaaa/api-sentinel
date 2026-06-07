package com.apisentinel.service;

import com.apisentinel.dto.DashboardResponse;
import com.apisentinel.repository.ApiEndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private ApiEndpointRepository apiEndpointRepository;

    public DashboardResponse getDashboardStats() {

        long totalApis = apiEndpointRepository.count();
        long upApis = apiEndpointRepository.countUpApis();
        long downApis = apiEndpointRepository.countDownApis();

        double successRate = 0;

        if (totalApis > 0) {
            successRate = ((double) upApis / totalApis) * 100;
        }

        DashboardResponse response = new DashboardResponse();

        response.setTotalApis(totalApis);
        response.setUpApis(upApis);
        response.setDownApis(downApis);
        response.setSuccessRate(successRate);

        return response;
    }
}