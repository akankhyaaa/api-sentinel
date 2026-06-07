package com.apisentinel.scheduler;

import com.apisentinel.entity.ApiEndpoint;
import com.apisentinel.repository.ApiEndpointRepository;
import com.apisentinel.service.ApiEndpointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.apisentinel.service.EmailService;
import com.apisentinel.dto.ApiHealthResponse;

import java.util.List;

@Component
public class ApiHealthScheduler {

    @Autowired
    private ApiEndpointRepository apiEndpointRepository;

    @Autowired
    private ApiEndpointService apiEndpointService;

    @Autowired
    private EmailService emailService;

    @Scheduled(fixedRate = 60000)
    public void monitorApis() {

        List<ApiEndpoint> apis = apiEndpointRepository.findAll();

        for (ApiEndpoint api : apis) {

            String oldStatus = api.getStatus();

        ApiHealthResponse healthResponse =
                apiEndpointService.checkApiHealth(api.getUrl());

        String newStatus = healthResponse.getStatus();

        api.setStatus(newStatus);

        api.setResponseTime(
        healthResponse.getResponseTime()
);

apiEndpointRepository.save(api);

if ("DOWN".equals(newStatus)
        && !"DOWN".equals(oldStatus)) {

    emailService.sendApiDownAlert(
            api.getApiName(),
            api.getUrl()
    );
}

System.out.println(
        api.getApiName() + " -> " + newStatus
);
        }
    }
}
