package com.example.jasper_reporting.controllers;

import com.example.jasper_reporting.service.EmployeeService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JsonDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping({"", "/"})
    public String viewReport(Model model) throws Exception {
        return "viewReport";
    }

    @RequestMapping({"/download"})
    public String downloadReport(Model model) throws Exception {
        String result =
                new RestTemplate().getForObject(
                        "http://localhost:8080/employee",
                        String.class
                );
        System.out.println(result);

        File file = ResourceUtils.getFile("classpath:reportTemplates/Employee.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        //Convert json string to byte array.
        ByteArrayInputStream jsonDataStream = new ByteArrayInputStream(result.getBytes());
        //Create json datasource from json stream
        JsonDataSource ds = new JsonDataSource(jsonDataStream);
        //Create HashMap to add report parameters
        Map parameters = new HashMap();
        //Add title parameter. Make sure the key is same name as what you named the parameters in jasper report.
        parameters.put("empId", "empId");
        parameters.put("name", "name");
        parameters.put("salary", "salary");
        parameters.put("designation", "designation");
        //Create Jasper Print object passing report, parameter json data source.
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, ds);
        //Export and save pdf to file
        JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\ehaque\\Desktop\\file\\jasperpdfexample.pdf");
//        File file2 = ResourceUtils.getFile("classpath:templates/Employee.html");
        JasperExportManager.exportReportToHtmlFile(jasperPrint,"C:\\Users\\ehaque\\Desktop\\file\\jasperpdfexample.html");

        return "layout";
    }
}
