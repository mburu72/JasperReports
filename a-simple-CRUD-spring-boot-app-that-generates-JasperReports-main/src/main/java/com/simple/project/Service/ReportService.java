package com.simple.project.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.simple.project.Repository.UserDao;
import com.simple.project.entity.User;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {



  
    @Autowired
  private final ResourceLoader resourceLoader;
  private UserDao usersDao;


 
  @Autowired
  public ReportService(ResourceLoader resourceLoader, UserDao usersDao){
    this.resourceLoader= resourceLoader;
    this.usersDao = usersDao;
    
  }

  public void generateReport(String inputPath, String outputPath){
    try{
      
    List<User> users = usersDao.findAll();
      JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(users);
        JasperReport report = JasperCompileManager.compileReport(resourceLoader.getResource(inputPath).getInputStream());

        Map<String, Object> parameters = new HashMap<String, Object>();
 
        parameters.put("generatedBy", "Edward"); 
        JasperPrint print = JasperFillManager.fillReport(report,parameters, dataSource);

        JasperExportManager.exportReportToPdfFile(print, outputPath);
    }
    catch(JRException | IOException e){
        e.printStackTrace();

    }
  }


   
}
