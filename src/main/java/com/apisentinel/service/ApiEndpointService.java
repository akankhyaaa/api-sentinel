package com.apisentinel.service;

import com.apisentinel.entity.ApiEndpoint;
import com.apisentinel.repository.ApiEndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import com.apisentinel.dto.ApiHealthResponse;

import java.util.List;

@Service
public class ApiEndpointService {

    @Autowired
    private ApiEndpointRepository apiEndpointRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ApiEndpoint saveApi(ApiEndpoint apiEndpoint) {
        return apiEndpointRepository.save(apiEndpoint);
    }

    public List<ApiEndpoint> getAllApis() {
        return apiEndpointRepository.findAll();
    }
    public ApiHealthResponse checkApiHealth(String url) {

    long startTime = System.currentTimeMillis();

    try {

        ResponseEntity<String> response =
                restTemplate.getForEntity(url, String.class);

        long endTime = System.currentTimeMillis();

        long responseTime = endTime - startTime;

        if (response.getStatusCode().is2xxSuccessful()) {

            return new ApiHealthResponse(
                    "UP",
                    responseTime
            );
        }

        return new ApiHealthResponse(
                "DOWN",
                responseTime
        );

    } catch (Exception e) {

        long endTime = System.currentTimeMillis();

        return new ApiHealthResponse(
                "DOWN",
                endTime - startTime
        );
    }
}
}
