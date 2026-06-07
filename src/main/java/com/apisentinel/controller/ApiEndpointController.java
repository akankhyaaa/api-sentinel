package com.apisentinel.controller;

import com.apisentinel.entity.ApiEndpoint;
import com.apisentinel.service.ApiEndpointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.apisentinel.dto.ApiHealthResponse;

@RestController
@RequestMapping("/api/endpoints")
public class ApiEndpointController {

    @Autowired
    private ApiEndpointService apiEndpointService;

    @PostMapping
    public ApiEndpoint saveApi(@RequestBody ApiEndpoint apiEndpoint) {
        return apiEndpointService.saveApi(apiEndpoint);
    }

    @GetMapping
    public List<ApiEndpoint> getAllApis() {
        return apiEndpointService.getAllApis();
    }

    @GetMapping("/check")
    public ApiHealthResponse checkApi(@RequestParam String url) {
        return apiEndpointService.checkApiHealth(url);
}
}
