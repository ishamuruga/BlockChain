package com.example.eth_spring_boot_students_marks.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;

import com.example.eth_spring_boot_students_marks.bc.model.Student;
import com.example.eth_spring_boot_students_marks.bc.model.StudentManager;
import com.example.eth_spring_boot_students_marks.bc.model.StudentManager.EvntStudentEventResponse;
import com.example.eth_spring_boot_students_marks.config.StudentConfig;

import io.reactivex.Completable;

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
    
    public void getStudent(int id) {
    	StudentManager sManager = StudentManager.load(
				sConfig.getContractAddress(),
				web3j,
				txManager(web3j,sConfig.getOwnerContractAddress()),
				sConfig.gas()
				);
    	RemoteFunctionCall<TransactionReceipt> tr = sManager.getStudent(new BigInteger(id+""));
    	TransactionReceipt trrec = null;
    	try {
    		trrec =	tr.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	List<EvntStudentEventResponse> res = sManager.getEvntStudentEvents(trrec);
    	System.out.println("RESPOSE++++++");
    	System.out.println(res.get(0).stu);  
    	
    	Student stu = Student.load(res.get(0).stu, 
    								web3j, 
    								txManager(web3j,sConfig.getOwnerContractAddress()),
    								sConfig.gas());

    	try {
			System.out.println(stu.name().send());
			System.out.println(stu.email().send());
			System.out.println(stu.id().send());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
    public void getStudentTag(int id) {
    	StudentManager sManager = StudentManager.load(
				sConfig.getContractAddress(),
				web3j,
				txManager(web3j,sConfig.getOwnerContractAddress()),
				sConfig.gas()
				);
    	RemoteFunctionCall<TransactionReceipt> tr = sManager.getStudentTag(new BigInteger(id+""));
    	try {
			TransactionReceipt trRec = tr.send();
			System.out.println(trRec.getStatus());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	CompletableFuture<TransactionReceipt> a = tr.sendAsync();
    	try {
			System.out.println(a.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
//		RemoteFunctionCall<TransactionReceipt> tr =  sManager.getStudent(new BigInteger(id+""));
//		
//		System.out.println("=====getStudent...");
//		TransactionReceipt trRec;
//		try {
//			trRec = tr.send();
//			System.out.println(trRec);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//System.out.println(trRec);
		//System.out.println(trRec.getTo());
		//System.out.println(tr.decodeFunctionResponse(tr.encodeFunctionCall()));

    }
    
    public void createStudent(BigInteger index,BigInteger id,String name,String email) {
    	StudentManager sManager = StudentManager.load(
    							sConfig.getContractAddress(),
    							web3j,
    							txManager(web3j,sConfig.getOwnerContractAddress()),
    							sConfig.gas()
    							);
    	RemoteFunctionCall<TransactionReceipt> a1 = sManager.createStudent(index,id,name,email);
    	try {
			a1.send();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	System.out.println("Added Student");
    
    //	try {
			
			//Student student = Student.load(trRec.getTo(), web3j, txManager(web3j,sConfig.getOwnerContractAddress()),
			//		sConfig.gas());
			
//			Student student = Student.load(trRec.getTransactionHash(), 
//								web3j, 
//								txManager(web3j,trRec.getFrom()),
//								sConfig.gas());
//			 CompletableFuture<BigInteger> fut=  student.id().sendAsync();
//			 System.out.println(fut.get());
//			
//			System.out.println(student.name().toString());
			//System.out.println(student.name().send());
			//System.out.println(student.email().send());
		//} catch (Exception e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
    	
    	
    	//Tuple3<String, String, BigInteger> rFun = null;
//		try {
//			rFun = sManager.students(new BigInteger(index+"")).send();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	System.out.println("Fetched Student....");
//    	
//    	System.out.println(rFun.getValue1().toString());
//    	
//    	System.out.println(rFun.getValue2().toString());
//    	System.out.println(rFun.getValue3().toString());
    } 
    
    private TransactionManager txManager(Web3j web3j,String address) {
        return new ClientTransactionManager(web3j, address);
    }
    
}
