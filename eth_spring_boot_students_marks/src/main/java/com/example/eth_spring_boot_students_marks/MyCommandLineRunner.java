package com.example.eth_spring_boot_students_marks;

import java.io.IOException;
import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.eth_spring_boot_students_marks.service.StudentBCService;

@Component
public class MyCommandLineRunner implements CommandLineRunner  {
    private static Logger LOG = LoggerFactory.getLogger(MyCommandLineRunner.class);
    
    @Autowired
    private StudentBCService bcService;
 
    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");

        System.out.println("========================From CmD Line Console");
 
        try {
			System.out.println(bcService.getBalance());
	        System.out.println(bcService.getOwnerBalance());
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        bcService.createStudent(new BigInteger("4"), new BigInteger("40"), "Ramarajan40", "ramarajan40@gmail.com");
        bcService.getStudent(4);
    }
}
