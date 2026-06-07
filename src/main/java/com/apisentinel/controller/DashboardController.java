package com.apisentinel.controller;

import com.apisentinel.dto.DashboardResponse;
import com.apisentinel.service.DashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/api/dashboard")
    public DashboardResponse getDashboardStats() {

        return dashboardService.getDashboardStats();
    }
}
