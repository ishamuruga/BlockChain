package com.example.eth_spring_boot_students_marks.service;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;

import com.example.eth_spring_boot_students_marks.bc.model.StudentManager;
import com.example.eth_spring_boot_students_marks.config.StudentConfig;

@Service
public class StudentBCService {

    @Autowired
    private Web3j web3j;
    
    @Autowired
    private StudentConfig sConfig;
    
    private String contractAddress;
    
    private String ownerContractAddress; 

   
//    StudentBCService() {
//    	
//    	
//    	
//    	contractAddress = sConfig.getOwnerContractAddress();
//    	ownerContractAddress = sConfig.getOwnerContractAddress();
//    }
    
    public BigInteger getBalance() throws IOException  {
    	System.out.println("+++++++++++++++++++++++++++++++++++");
    	contractAddress = sConfig.getContractAddress();
    	System.out.println(sConfig.getWeb3ClientAddress());
    	System.out.println("contractAddress.." + contractAddress);
    	return web3j.ethGetBalance(contractAddress, DefaultBlockParameterName.LATEST).send().getBalance();
    }
    
    public BigInteger getOwnerBalance() throws IOException  {
    	System.out.println("+++++++++++++++++++++++++++++++++++");
    	ownerContractAddress = sConfig.getOwnerContractAddress();
    	System.out.println("ownerContractAddress.." + ownerContractAddress);
    	
    	return web3j.ethGetBalance(ownerContractAddress, DefaultBlockParameterName.LATEST).send().getBalance();
    }
    
    public void createStudent(int index,int id,String name) {
    	StudentManager sManager = StudentManager.load(
    							sConfig.getContractAddress(),
    							web3j,
    							txManager(web3j,sConfig.getOwnerContractAddress())
    							);
    }
    
    private TransactionManager txManager(Web3j web3j,String address) {
        return new ClientTransactionManager(web3j, address);
    }
    
}
