package com.simple.project.Controller.Report;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.project.Service.ReportService;

@RestController
public class ReportController {

    @Autowired
    private ReportService rService;

    
  
    @GetMapping("/report")
    public void generateReport(){
        String inputPath = "classpath:users.jrxml";
        String outputPath = "src\\main\\resources\\Report\\usersReport.pdf";
        rService.generateReport(inputPath, outputPath);
    }
}
